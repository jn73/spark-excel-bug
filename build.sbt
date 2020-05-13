name := "spark-excel-bug"

version := "0.1"

scalaVersion := "2.12.11"

libraryDependencies ++= Seq(
  "com.crealytics" %% "spark-excel" % "0.13.1",
  "org.apache.spark" %% "spark-sql" % "2.4.5",
  "org.scalatest" %% "scalatest" % "3.0.8"
)