package com.example.stream


import java.util.Date

import akka.actor.ActorSystem
import akka.stream.scaladsl._
import akka.stream.{ActorMaterializer, ThrottleMode}

import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration._

/**
  * author Yuki Hirai on 2017/08/30.
  */
object ThrottleStream extends App {
  implicit val system: ActorSystem = ActorSystem("throttle-stream")
  implicit val mat: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContextExecutor = system.dispatcher
  // 1秒おきにhogeが1回printされる
  // Source.repeat("hoge").throttle(1, 1.second, 0, ThrottleMode.shaping).runForeach(println)
  // 1秒おきにhogeが3回printされる
  // Source.repeat("hoge").throttle(3, 1.second, 0, ThrottleMode.shaping).runForeach(println)
  // 1時間の中でhogeが3回printされる(20分おきに1回ずつ)
  println(s"------------start time: ${new Date()}")
  Source.repeat("hoge").throttle(3, 1.hour, 0, ThrottleMode.shaping).runForeach{x =>
    println(s"------------execute time: ${new Date()}")
    println(x)
  }
}
