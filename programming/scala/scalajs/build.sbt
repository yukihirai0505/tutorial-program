enablePlugins(ScalaJSPlugin)

name := """scalajs"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "be.doeraene" %%% "scalajs-jquery" % "0.8.0",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

//
scalaJSStage in Global := FastOptStage
// 依存するJavaScriptライブラリをひとつにまとめてくれる
skip in packageJSDependencies := false