organization := "name.heikoseeberger"

name := "scala-in-action"

scalaVersion := "2.10.2"

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-language:_",
  "-target:jvm-1.7",
  "-encoding", "UTF-8"
)

libraryDependencies ++= Seq(
  "org.apache.httpcomponents" % "httpclient" % "4.2.5",
  "org.scalatest" %% "scalatest" % "2.0.RC1-SNAP4" % "test"
)

fork in run := true
