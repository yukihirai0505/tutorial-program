package services

import models.SampleEntity
import net.sf.ehcache.{CacheManager, Element}

import scala.concurrent.{ExecutionContextExecutor, Future}

class SampleService(implicit ec: ExecutionContextExecutor) {

  lazy val cacheManager = CacheManager.getInstance()
  val cacheKey = "myCache"

  def getSample: Future[Seq[SampleEntity]] = {
    val cache = cacheManager.getCache(cacheKey)
    val hoge = cache.get("hoge")
    if (hoge != null) {
      return Future successful hoge.getObjectValue.asInstanceOf[Seq[SampleEntity]]
    }
    cache.put(new Element("hoge", Seq(
      SampleEntity(
        username = "hoge",
        email = "hogehogehoge"
      )
    )))
    Future successful Seq(
      SampleEntity(
        username = "hoge",
        email = "hoge@xxx.com"
      ),
      SampleEntity(
        username = "sage",
        email = "sage@xxx.com"
      )
    )
  }

}