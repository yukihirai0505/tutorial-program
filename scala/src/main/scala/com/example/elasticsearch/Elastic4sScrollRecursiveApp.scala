package com.example.elasticsearch

import akka.actor.ActorSystem
import com.sksamuel.elastic4s.ElasticsearchClientUri
import com.sksamuel.elastic4s.http.HttpClient
import com.sksamuel.elastic4s.http.search.{SearchHit, SearchResponse}

import scala.concurrent.{ExecutionContextExecutor, Future}

object Elastic4sScrollRecursiveApp extends App with ElasticsearchConstants {

  // you must import the DSL to use the syntax helpers
  import com.sksamuel.elastic4s.http.ElasticDsl._

  val client = HttpClient(ElasticsearchClientUri("localhost", 9200))

  def searchTags(implicit ec: ExecutionContextExecutor): Future[Seq[InstagramHashTagEntity]] = {
    val keepAlive = "1m"
    val result: Future[SearchResponse] = client.execute {
      search(indexName / TypeName.Tags).scroll(keepAlive).size(searchSize).matchAllQuery()
    }
    result.flatMap { r =>
      def getAll(scrollId: Option[String], entities: Seq[SearchHit]): Seq[SearchHit] = {
        // scrollIdがあれば検索かける
        scrollId match {
          case Some(id) =>
            val sr = client.execute {
              searchScroll(id).keepAlive(keepAlive)
            }.await
            val data = sr.hits.hits.toSeq
            if (data.isEmpty) entities else getAll(sr.scrollId, entities ++ data)
          case None => entities
        }
      }
      val searchHits = r.hits.hits.toSeq
      val scrollId = r.scrollId
      Future successful getAll(scrollId, searchHits).map { data =>
        InstagramHashTagEntity(
          data.sourceAsMap.getOrElse("name", "").toString
        )
      }
    }
  }

  implicit val system = ActorSystem("hoge")
  implicit val ec = system.dispatcher
  Future successful println(searchTags.await.size)
  client.close()
}

case class InstagramHashTagEntity(
                                   name: String,
                                   mediaCount: Long = 0
                                 )

trait ElasticsearchConstants {
  val searchSize = 1000
  val indexName = "tagpush"

  object TypeName {
    val Tags = "tags"
    val Posts = "posts"
    val Users = "users"
  }

}