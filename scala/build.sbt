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
    // Joda
    "joda-time" % "joda-time" % "2.9.3",
    // Test
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  )
}

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"
