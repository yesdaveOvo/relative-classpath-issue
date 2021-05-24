import sbt.io.Path.directory

name := "relative-classpath-issue"

version := "0.1"

scalaVersion := "2.13.6"

lazy val root =
  (project in file("."))
    .enablePlugins(JavaAppPackaging)

mappings in Universal ++= directory(baseDirectory.value / "conf" )

scriptClasspath := {
  val scriptClasspathValue = scriptClasspath.value
    "../conf/" +: scriptClasspathValue
}
