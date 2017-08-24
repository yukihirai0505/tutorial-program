package com.example

/**
  * author Yuki Hirai on 2017/08/24.
  */
import akka.actor._
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Source,Sink}
import scala.concurrent.ExecutionContext.Implicits.global

case class User(name:String)

object SeqStream extends App{
  implicit val system = ActorSystem("MyActorSystem")
  implicit val materializer = ActorMaterializer()
  val users = Seq(User("alice"),User("bob"),User("charlie"))

  val sink = Sink.fold[Seq[User], User](Seq())(
    (seq, elem) =>
    {println(s"elem => ${elem} \t| seq => ${seq}");seq:+elem})

  val src = Source(users.to[scala.collection.immutable.Seq])
  //val src = Source(()=>users.iterator) // this also works

  val fut = src.runWith(sink) // Future[Seq[User]]
  fut.onSuccess({
    case x=>{
      println(s"result => ${x}")
    }
  })
}