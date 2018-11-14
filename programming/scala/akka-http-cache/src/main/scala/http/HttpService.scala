package http

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import http.routes._
import services._
import utils.CorsSupport

import scala.concurrent.ExecutionContextExecutor

class HttpService(sampleService: SampleService
                 )(implicit ec: ExecutionContextExecutor, actorSystem: ActorSystem, materializer: ActorMaterializer) extends CorsSupport {

  val sampleRouter = new SampleRoute(sampleService)

  val routes =
    pathPrefix("v1") {
      corsHandler {
        sampleRouter.route
      }
    }

}
