import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import http.HttpService
import services._
import utils.Config

import scala.concurrent.ExecutionContextExecutor

object Main extends App with Config {
  implicit val actorSystem = ActorSystem()
  implicit val executor: ExecutionContextExecutor = actorSystem.dispatcher
  implicit val log: LoggingAdapter = Logging(actorSystem, getClass)
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val sampleService = new SampleService()

  val httpService = new HttpService(
    sampleService
  )

  Http().bindAndHandle(httpService.routes, httpHost, httpPort)
}
