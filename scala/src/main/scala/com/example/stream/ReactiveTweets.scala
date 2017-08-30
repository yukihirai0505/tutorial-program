package com.example.stream

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}
import akka.{Done, NotUsed}

import scala.concurrent.Future

object ReactiveTweets extends App {

  import DataModel._
  implicit val system = ActorSystem("reactive-tweets")
  implicit val materializer = ActorMaterializer()

  // source
  val tweets: Source[Tweet, NotUsed] = Source.repeat(sampleTweet).take(5)

  val authors: Source[Author, NotUsed] = tweets
    .filter(_.hashtags.contains(akkaTag))
    .map(_.author)

  val a: Future[Done] = authors.runWith(Sink.foreach(println))

}

final case class Author(handle: String)
final case class Hashtag(name: String)

final case class Tweet(author: Author, timestamp: Long, body: String) {
  def hashtags: Set[Hashtag] =
    body.split(" ").collect {
      case t if t.startsWith("#") => Hashtag(t)
    }.toSet
}

object DataModel {
  val akkaTag = Hashtag("#akka")
  val sampleTweet = Tweet(Author("author handle"), System.currentTimeMillis, "some body #dupa #akka")
}