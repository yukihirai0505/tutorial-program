name := """spark"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies ++= {
  val sparkV = "2.2.0"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkV,
    "org.apache.spark" %% "spark-streaming" % sparkV,
    "org.apache.bahir" %% "spark-streaming-twitter" % sparkV,
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  )
}
