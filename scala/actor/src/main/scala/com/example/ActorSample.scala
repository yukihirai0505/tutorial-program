package com.example

import akka.actor.{Actor, ActorSystem, Props}
import akka.routing.RoundRobinRouter

object ActorSample {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("helloSystem")
    val router = system.actorOf(Props[HelloActor].withRouter(RoundRobinRouter(4)))
    router ! "Hello"
    router ! "Bad"
    router ! "Bad"
    router ! "Hello"
    router ! "Hello"
    system.shutdown()
  }
}

class HelloActor extends Actor {
  override def receive: Receive = {
    case "Hello" => println("Hello World!")
    case _ => println("Bad World!!")
  }
}