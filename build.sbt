ThisBuild / scalaVersion := "2.13.1"
ThisBuild / organization := "com.example"

lazy val root = (project in file("."))
  .settings(
    name := "typeclass-exercises",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.7.0",
      "org.typelevel" %% "discipline-scalatest" % "2.1.5" % Test,
    )
  )
