package com.example.stream

import akka.Done
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

/**
  * Created by yukyh on 2017/08/25.
  */
object SingleSource extends App {
  implicit val system = ActorSystem("akka-streams-example")
  implicit val materializer = ActorMaterializer()
  implicit val ec: ExecutionContextExecutor = system.dispatcher
  val helloWorldStream: RunnableGraph[Future[Done]] =
    Source.single("Hello world")
      .map(s => s.toUpperCase())
      .toMat(Sink.foreach(println))(Keep.right)
  val doneF: Future[Done] = helloWorldStream.run()
  doneF.onComplete {
    case Success(Done) =>
      println("Stream finished successfully.")
    case Failure(e) =>
      println(s"Stream failed with $e")
  }
}
