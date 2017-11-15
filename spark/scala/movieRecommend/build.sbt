name := """movieRecommend"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  val sparkV = "2.2.0"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkV,
    "org.apache.spark" %% "spark-mllib" % "2.2.0",
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  )
}