name := "sampleApi"
version := "1.0.0"
scalaVersion := "2.11.7"

assemblyOutputPath in assembly := file("./api-standalone.jar")

libraryDependencies ++= {
  val akkaV = "10.0.7"
  val scalaTestV = "3.0.1"
  val circeV = "0.6.1"
  Seq(

    "commons-codec" % "commons-codec" % "1.10",

    "com.typesafe.akka" %% "akka-http-core" % akkaV,
    "com.typesafe.akka" %% "akka-http" % akkaV,
    "de.heikoseeberger" %% "akka-http-circe" % "1.11.0",

    // cache
    "net.sf.ehcache" % "ehcache" % "2.10.0",

    "io.circe" %% "circe-core" % circeV,
    "io.circe" %% "circe-generic" % circeV,
    "io.circe" %% "circe-parser" % circeV,

    "org.scalatest" %% "scalatest" % scalaTestV % "test",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV % "test"
  )
}

Revolver.settings
enablePlugins(JavaAppPackaging)
