resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("io.spray" %% "sbt-revolver" % "0.8.0")
addSbtPlugin("com.typesafe.sbt" %% "sbt-native-packager" % "1.1.4")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.2")