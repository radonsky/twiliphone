name := """twiliphone"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
.enablePlugins(PlayScala)
.enablePlugins(JavaAppPackaging)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "com.twilio.sdk" % "twilio-java-sdk" % "4.0.0"
)

