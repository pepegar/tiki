inThisBuild(List(
  organization := "com.pepegar",
  homepage := Some(url("https://github.com/pepegar/tiki")),
  licenses := List(("MIT", url("http://opensource.org/licenses/MIT"))),
  developers := List(
    Developer(
      "pepegar",
      "Pepe Garcia",
      "pepe@pepegar.com",
      url("https://pepegar.com")
    )
  ),
  scalaVersion := "2.13.1",
))

lazy val root = project.dependsOn(core, docs).aggregate(core, docs)

lazy val core = project.in(file("."))
    .settings(commonSettings, releaseSettings)
    .settings(
      name := "tiki"
    )

lazy val docs = project.in(file("docs"))
    .dependsOn(core)
    .enablePlugins(MicrositesPlugin)

lazy val V = new {
  val cats = "2.0.0"
  val kittens = "2.0.0"
  val catsEffect = "2.0.0"
  val mouse = "0.23"
  val shapeless = "2.3.3"
  val fs2 = "2.0.1"
  val circe = "0.12.1"
  val droste = "0.7.0"
  val specs2 = "4.7.1"
  val discipline = "1.0.0"
  val kindProjector = "0.10.3"
  val betterMonadicFor = "0.3.1"
}


// check for library updates whenever the project is [re]load
onLoad in Global := { s =>
  "dependencyUpdates" :: s
}

// General Settings
lazy val commonSettings = Seq(
  crossScalaVersions := Seq(scalaVersion.value, "2.12.10"),
  scalafmtOnCompile in ThisBuild := true,

  addCompilerPlugin("org.typelevel" % "kind-projector" % V.kindProjector cross CrossVersion.binary),
  addCompilerPlugin("com.olegpy" %% "better-monadic-for" % V.betterMonadicFor),
  libraryDependencies ++= Seq(
    "org.typelevel"               %% "cats-core"                  % V.cats,

    "org.typelevel"               %% "kittens"                    % V.kittens,
    "org.typelevel"               %% "alleycats-core"             % V.cats,
    "org.typelevel"               %% "mouse"                      % V.mouse,

    "org.typelevel"               %% "cats-effect"                % V.catsEffect,

    "com.chuusai"                 %% "shapeless"                  % V.shapeless,

    "co.fs2"                      %% "fs2-core"                   % V.fs2,
    "co.fs2"                      %% "fs2-io"                     % V.fs2,

    "io.circe"                    %% "circe-core"                 % V.circe,
    "io.circe"                    %% "circe-generic"              % V.circe,
    "io.circe"                    %% "circe-parser"               % V.circe,

    "org.specs2"                  %% "specs2-core"                % V.specs2       % Test,
    "org.specs2"                  %% "specs2-scalacheck"          % V.specs2       % Test,
    "org.typelevel"               %% "discipline-core"            % V.discipline   % Test,
  )
)

lazy val releaseSettings = {
  import ReleaseTransformations._
  Seq(
    releaseCrossBuild := true,
    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      // For non cross-build projects, use releaseStepCommand("publishSigned")
      releaseStepCommandAndRemaining("+publishSigned"),
      setNextVersion,
      commitNextVersion,
      releaseStepCommand("sonatypeReleaseAll"),
      pushChanges
    ),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/pepegar/tiki"),
        "git@github.com:pepegar/tiki.git"
      )
    ),
    homepage := Some(url("https://github.com/pepegar/tiki")),
  )
}

lazy val mimaSettings = {
  import sbtrelease.Version

  def semverBinCompatVersions(major: Int, minor: Int, patch: Int): Set[(Int, Int, Int)] = {
    val majorVersions: List[Int] = List(major)
    val minorVersions : List[Int] =
      if (major >= 1) Range(0, minor).inclusive.toList
      else List(minor)
    def patchVersions(currentMinVersion: Int): List[Int] =
      if (minor == 0 && patch == 0) List.empty[Int]
      else if (currentMinVersion != minor) List(0)
      else Range(0, patch - 1).inclusive.toList

    val versions = for {
      maj <- majorVersions
      min <- minorVersions
      pat <- patchVersions(min)
    } yield (maj, min, pat)
    versions.toSet
  }

  def mimaVersions(version: String): Set[String] = {
    Version(version) match {
      case Some(Version(major, Seq(minor, patch), _)) =>
        semverBinCompatVersions(major.toInt, minor.toInt, patch.toInt)
          .map{case (maj, min, pat) => maj.toString + "." + min.toString + "." + pat.toString}
      case _ =>
        Set.empty[String]
    }
  }
  // Safety Net For Exclusions
  lazy val excludedVersions: Set[String] = Set()

  // Safety Net for Inclusions
  lazy val extraVersions: Set[String] = Set()

  Seq(
    mimaFailOnProblem := mimaVersions(version.value).toList.headOption.isDefined,
    mimaPreviousArtifacts := (mimaVersions(version.value) ++ extraVersions)
      .filterNot(excludedVersions.contains(_))
      .map{v =>
        val moduleN = moduleName.value + "_" + scalaBinaryVersion.value.toString
        organization.value % moduleN % v
      },
    mimaBinaryIssueFilters ++= {
      import com.typesafe.tools.mima.core._
      import com.typesafe.tools.mima.core.ProblemFilters._
      Seq()
    }
  )
}

lazy val micrositesSettings = Seq(
    micrositeName := "tiki",
    micrositeDescription := "Purely functional HTTP client",
    micrositeBaseUrl := "tiki",
    micrositeDocumentationUrl := s"https://www.javadoc.io/doc/${organization.value}/tiki-core_2.12",
    micrositeGithubOwner := "pepegar",
    micrositeGithubRepo := "tiki",
    micrositeHighlightTheme := "tomorrow",
    micrositePushSiteWith := GitHub4s,
    micrositeGithubToken := sys.env.get("GITHUB_TOKEN"),
    micrositeCompilingDocsTool := WithMdoc,
    mdocIn := tutSourceDirectory.value
)

lazy val skipOnPublishSettings = Seq(
  skip in publish := true,
  publish := (()),
  publishLocal := (()),
  publishArtifact := false,
  publishTo := None
)
