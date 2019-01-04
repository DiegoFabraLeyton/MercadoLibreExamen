name := """examen"""
organization := "mercadolibre"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.7"

libraryDependencies += guice
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.8.1"
libraryDependencies += "org.apache.commons" % "commons-math3" % "3.6.1"
libraryDependencies += "org.jongo" % "jongo" % "1.4.0"
libraryDependencies += "org.mongodb" % "mongo-java-driver" % "3.9.1"
resolvers += "tuxburner.github.io" at "http://tuxburner.github.io/repo"
libraryDependencies += "com.github.tuxBurner" %% "play-akkajobs" % "2.6.1"
libraryDependencies += "org.mockito" % "mockito-core" % "2.10.0" % "test"
