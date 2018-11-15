import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.elbauldelprogramador",
      scalaVersion := "2.12.4"
    )),
    name := "ds-and-algorithms",
    libraryDependencies ++= testDeps ++ logs
  )
