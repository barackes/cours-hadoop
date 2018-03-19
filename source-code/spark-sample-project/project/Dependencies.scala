import sbt._

object Dependencies {

  object Versions {
    val spark = "2.3.0"
  }

  lazy val sparkCore = "org.apache.spark" %% "spark-core" % Versions.spark % Provided
  lazy val sparkSql = "org.apache.spark" %% "spark-sql" % Versions.spark % Provided

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % Test
}
