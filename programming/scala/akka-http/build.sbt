name := """akka-http"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer

libraryDependencies ++= {
  val akkaV = "10.0.10"
  Seq(
    // Akka
    "com.typesafe.akka" %% "akka-http" % akkaV,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaV,
  // Test
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  )
}


// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

