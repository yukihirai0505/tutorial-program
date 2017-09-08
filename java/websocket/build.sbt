name := """websocket"""

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= {
  val tyrusV = "1.1"
  Seq(
    // Uncomment to use Akka
    //"com.typesafe.akka" % "akka-actor_2.11" % "2.3.9",
    "org.glassfish.tyrus" % "tyrus-server" % tyrusV,
    "org.glassfish.tyrus" % "tyrus-client" % tyrusV,
    "org.glassfish.tyrus" % "tyrus-container-grizzly" % tyrusV,
    "javax.websocket" % "javax.websocket-api" % "1.0" % "provided",
    "junit"             % "junit"           % "4.12"  % "test",
    "com.novocode"      % "junit-interface" % "0.11"  % "test"
  )
}
