package com.example.stream

import java.io.{File, IOException}
import javax.imageio.ImageIO

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Source, _}
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.model.Element

import scala.concurrent.{ExecutionContext, Future}
import scala.sys.process._
import scalax.io.Resource

object ScrapeStream extends App {
  new ScrapeStream().run()
}

class ScrapeStream {
  implicit val system = ActorSystem("HogeSystem")
  implicit val materializer = ActorMaterializer()
  implicit val ec: ExecutionContext = ExecutionContext.Implicits.global

  val targetUrls: List[String] = List(
    // スクレーピングしたいページのURL
    "http://qiita.com/ara_ta3/items/8bf8c6ffec86884fb6cb"
  )
  val scraper = new ScrapeImpl()

  val source = Source(targetUrls).mapAsyncUnordered(3) { url =>
    scraper.scrape(url)
  }

  val step = Flow[List[File]].mapAsyncUnordered(3) { files =>
    Future(
      for {
        file <- files
        if imageSizeCheck(file)
      } yield file
    )
  }

  val sink = Sink.foreachParallel[List[File]](3) { files =>
    files.map(file => moveImage(file))
  }

  //source, flow, sinkを連結してgraphを作成。
  val graph = source via step to sink

  def run(): Unit = {
    //runメソッドで実行
    graph.run()
  }

  def imageSizeCheck(file: File) = {
    try {
      val image = ImageIO.read(file)
      //100 x 100以上かチェック
      image.getHeight() >= 100 && image.getWidth() >= 100
    } catch {
      case e: IOException => false
    }
  }

  def moveImage(file: File) = {
    val path = file.getPath
    Process("mv " + path + file.getName).lineStream
  }
}

class ScrapeImpl {
  val browser = JsoupBrowser()
  var sequence = 1
  implicit val ec: ExecutionContext = ExecutionContext.Implicits.global

  /**
    * urlのページをスクレープ
    */
  def scrape(url: String) = Future {
    println(s"----------------- start scraping url: $url")
    val doc = browser.get(url)
    println(s"----------------- get doc")
    //htmlからimgタグだけ抽出
    val images = doc >?> elementList("img")
    println(s"----------------- get images")
    images match {
      case Some(l) => download(l)
      case None => List.empty[File]
    }
  }

  /**
    * 画像ダウンロード
    */
  def download(list: List[Element]) = {
    for {
      e <- list
      if e.attr("src").startsWith("http://") || e.attr("src").startsWith("https://")
    } yield {
      save(e.attr("src"))
    }
  }

  /**
    * ダウンロードした画像を保存
    */
  private def save(url: String) = {
    val data = Resource.fromURL(url).byteArray
    val file = new File("./images/" + sequence)
    sequence += 1
    Resource.fromFile(file).write(data)
    file
  }

}
