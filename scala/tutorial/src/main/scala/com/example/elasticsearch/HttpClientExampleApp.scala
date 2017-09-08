package com.example.elasticsearch

import com.sksamuel.elastic4s.ElasticsearchClientUri
import com.sksamuel.elastic4s.http.HttpClient
import com.sksamuel.elastic4s.http.search.SearchResponse
import org.elasticsearch.action.support.WriteRequest.RefreshPolicy

object HttpClientExampleApp extends App {

  // you must import the DSL to use the syntax helpers
  import com.sksamuel.elastic4s.http.ElasticDsl._

  val client = HttpClient(ElasticsearchClientUri("localhost", 9200))
  val indexName = "myindex"
  val typeName = "mytype"
  val indexNameAndType = indexName / typeName

  client.execute {
    bulk(
      indexInto(indexNameAndType).fields("country" -> "Mongolia", "capital" -> "Ulaanbaatar"),
      indexInto(indexNameAndType).fields("country" -> "Namibia", "capital" -> "Windhoek")
    ).refresh(RefreshPolicy.WAIT_UNTIL)
  }.await

  val result: SearchResponse = client.execute {
    search(indexName).matchQuery("capital", "ulaanbaatar")
  }.await

  // prints out the original json
  println(result.hits.hits.head.sourceAsString)

  client.close()

}