name := """scala"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  val akkaStreamV = "2.5.2"
  Seq(
    // Akka
    "com.typesafe.akka" %% "akka-stream" % akkaStreamV,
    // Elasticsearch
    "org.apache.lucene" % "lucene-core" % "3.6.0",
    "com.sksamuel.elastic4s" %% "elastic4s-http" % "5.4.2",
    // File
    "org.scalaforge" % "scalax" % "0.1",
    "com.github.scala-incubator.io" % "scala-io-core_2.11" % "0.4.3",
    "com.github.scala-incubator.io" % "scala-io-file_2.11" % "0.4.3",
    // Web Scrape
    "net.ruippeixotog" %% "scala-scraper" % "2.0.0",
    // Joda
    "joda-time" % "joda-time" % "2.9.3",
    // Test
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  )
}

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"
