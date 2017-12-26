package http.routes

import akka.http.scaladsl.server.Directives._
import de.heikoseeberger.akkahttpcirce.CirceSupport
import io.circe.generic.auto._
import io.circe.syntax._
import services.SampleService

import scala.concurrent.ExecutionContextExecutor

class SampleRoute(sampleRoute: SampleService
                 )(implicit ec: ExecutionContextExecutor) extends CirceSupport {

  import sampleRoute._

  val route = pathPrefix("sample") {
    pathEndOrSingleSlash {
      get {
        complete(getSample.map(_.asJson))
      }
    }
  }

}
