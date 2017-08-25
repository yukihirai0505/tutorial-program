package com.example

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._

/**
  * Created by yukyh on 2017/08/25.
  */
object SingleSource extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  val helloWorldStream: RunnableGraph[NotUsed] =
    Source.single("Hello world")
      .via(Flow[String].map(s => s.toUpperCase()))
      .to(Sink.foreach(println))
  helloWorldStream.run()
}
