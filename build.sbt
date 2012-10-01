
organization := "name.heikoseeberger"

name := "scala-in-action"

scalaVersion := "2.10.1"

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
  "org.scalatest" %% "scalatest" % "2.0.M6-SNAP20" % "test",
  "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
)

fork in run := true
