import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

def convertFutureSeq[A](f: Seq[Future[A]]): Future[Seq[A]] = {
  Future.sequence(f.map(_.map(Some(_)).recover { case _ => None })).map(_.flatten)
}

val sequence = Seq(Future successful 1, Future successful 2,Future successful 3)

// Seq[Future[Int]] to Future[Seq[Int]]
convertFutureSeq(sequence)