import sbt.Keys._
import sbt._
import spray.revolver.RevolverPlugin.autoImport.Revolver


object Dependencies {

  private val akka = "2.4.17"
  private val akkaHttp = "10.0.5"
  val appDependencies = Seq(
    "com.typesafe.akka" %% "akka-http" % akkaHttp,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttp % "test",
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttp,
    "com.typesafe.akka" %% "akka-http-jackson" % akkaHttp,
    "com.typesafe.akka" %% "akka-http-xml" % akkaHttp
  )

}

object BuildSettings {

  val buildOrganization = ""
  val appName = "scala-samples"
  val buildVersion = "0.0.5"
  val buildScalaVersion = "2.11.8"
  val buildScalaOptions = Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

  import Dependencies._

  val buildSettings = Defaults.coreDefaultSettings ++ Seq(
    organization := buildOrganization,
    version := buildVersion,
    scalaVersion := buildScalaVersion,
    libraryDependencies ++= appDependencies,
    scalacOptions := buildScalaOptions,
    fork in Test := true,
    javaOptions += "-Ddev=true"
  ) ++ Revolver.settings

}
object ApplicationBuild extends Build {

  import BuildSettings._

  lazy val root = Project(appName, file("."), settings = buildSettings );

}


