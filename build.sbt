
lazy val organizationSettings = Seq(
  organization := "io.github.vyunsergey",
  name := "scala-learn",
  homepage := Some(url("https://github.com/VyunSergey")),
  licenses := Seq(("Apache License, Version 2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html")))
)

lazy val `scala-learn` = (project in file (".")).settings(
  scalaVersion := "2.12.15",
  organizationSettings,
  scalacOptions ++= scalaCompilerOptions
)

lazy val scalaCompilerOptions = Seq(
  "-deprecation",                  // Emit warning and location for usages of deprecated APIs
  "-unchecked",                    // Enable additional warnings where generated code depends on assumptions
  "-feature",                      // Emit warning and location for usages of features that should be imported explicitly
  "-encoding", "UTF-8",            // Specify character encoding used by source files
  "-language:implicitConversions", // Allow definition of implicit functions called views
  "-language:existentials",        // Existential types (besides wildcard types) can be written and inferred
  "-language:higherKinds",         // Allow higher-kinded types
  "-language:postfixOps",          // Allows operator syntax in postfix position (deprecated since Scala 2.10)
  "-Xfatal-warnings"               // Fail the compilation if there are any warnings
)
