import sbt._

object Dependencies {
  val akkaVersion = "2.6.7"
  val akkaHttpVersion = "10.1.12"
  val scalikejdbcVersion = "3.4.2"
  val macwireVersion = "2.3.6"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.1.2"
  lazy val jedis     = "redis.clients"  % "jedis"     % "3.3.0"

  lazy val macwire = Seq(
    "com.softwaremill.macwire" %% "macros"     % macwireVersion % "provided",
    "com.softwaremill.macwire" %% "macrosakka" % macwireVersion % "provided",
    "com.softwaremill.macwire" %% "util"       % macwireVersion,
    "com.softwaremill.macwire" %% "proxy"      % macwireVersion
  )

  lazy val scalikejdbc = Seq(
    "mysql"         % "mysql-connector-java" % "8.0.17",
    "org.scalikejdbc" %% "scalikejdbc"       % scalikejdbcVersion
  )
  lazy val scalikejdbcStreams = "org.scalikejdbc" %% "scalikejdbc-streams" % scalikejdbcVersion

  lazy val pureconfig = "com.github.pureconfig" %% "pureconfig" % "0.12.3"

  lazy val akka = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % "test",
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % "test"
  )

  lazy val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
}
