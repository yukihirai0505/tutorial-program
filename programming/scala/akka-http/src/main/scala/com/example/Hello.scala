package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.marshalling.Marshal
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, RequestEntity}
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import spray.json._

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

// domain model
final case class EdgesNode(id: String)

final case class Edges(node: EdgesNode)

final case class EdgeHashtagToMedia(edges: Seq[Edges])

final case class Hashtag(edgeHashtagToMedia: EdgeHashtagToMedia)

final case class InstagramMediaData(hashtag: Hashtag)

final case class InstagramMediaResponse(data: InstagramMediaData)

// collect your json format instances into a support trait:
trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val EdgesNodeFormat = jsonFormat1(EdgesNode)
  implicit val EdgesFormat = jsonFormat1(Edges)
  implicit val EdgeHashtagToMediaFormat = jsonFormat1(EdgeHashtagToMedia)
  implicit val HashtagFormat = jsonFormat1(Hashtag)
  implicit val InstagramMediaDataFormat = jsonFormat1(InstagramMediaData)
  implicit val InstagramMediaResponseFormat = jsonFormat1(InstagramMediaResponse)
}

object Hello extends App with JsonSupport {


  implicit val system: ActorSystem = ActorSystem("Hello")
  implicit val ec: ExecutionContextExecutor = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val uri = "https://api.yabaiwebyasan.com/v1/instagram/tags/idonotlikefashion/media"
  val reqEntity = Array[Byte]()

  case class Hoge(data: String)

  val respEntity: Future[String] = for {
    request <- Marshal(reqEntity).to[RequestEntity]
    response <- Http().singleRequest(HttpRequest(method = HttpMethods.GET, uri = uri, entity = request))
    entity1 <- Unmarshal(response.entity).to[String]
  } yield entity1

  val payload = respEntity.andThen {
    case Success(entity) =>
      val json = entity.parseJson.convertTo[InstagramMediaResponse]
      println(s"""{"content": "$entity"}""")
    case Failure(ex) =>
      s"""{"error": "${ex.getMessage}"}"""
  }

}
