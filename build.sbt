name := "Root Project"

// Common settings shared with all projects
lazy val commonSettings: Seq[Setting[_]] = Seq(
  organization := "com.exitiumonline",
  version := "1.0.0",
  scalaVersion := "2.11.5",
  scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-Xfatal-warnings",
    "-Xlint"
  )
)

lazy val bar = (project in file("bar")).settings(commonSettings: _*)
lazy val baz = (project in file("baz")).settings(commonSettings: _*)
lazy val foo = (project in file("foo")).settings(commonSettings: _*) dependsOn(bar, baz)

// The magic
onLoad in Global := (Command.process("project foo", _: State)) compose (onLoad in Global).value
