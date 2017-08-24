package com.example

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.scaladsl._
import akka.stream.{ActorMaterializer, ClosedShape}


object Hello extends App {

  implicit val system: ActorSystem = ActorSystem() // Actorを使うのでActorSystemが必要
  implicit val mat: ActorMaterializer = ActorMaterializer()

  val source = Source[Int](1 to 5) // Publisherのこと
  val sink = Sink.foreach[Int](println) // Subscriberのこと
  val step1 = Flow[Int].map(_ * 2) // Stageのことで処理の流れの1つ
  val step2 = Flow[Int].map(_ + 100) // Stageのことで処理の流れの1つ

  val g = RunnableGraph.fromGraph(GraphDSL.create() { implicit builder: GraphDSL.Builder[NotUsed] =>
    val bcast = builder.add(Broadcast[Int](2))
    val merge = builder.add(Merge[Int](2))
    import GraphDSL.Implicits._
    source ~> bcast ~> step1 ~> merge ~> sink
    bcast ~> step2 ~> merge
    ClosedShape
  })

  g.run()

}
