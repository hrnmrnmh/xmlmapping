import Dependencies._
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "xmlmapping",
    libraryDependencies += scalaTest % Test
  )

libraryDependencies += "org.json4s" %% "json4s-xml" % "3.6.7"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.7"
