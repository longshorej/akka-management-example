name := "akka-cluster-tooling-example-app1"

version := "0.1.0"

enablePlugins(JavaServerAppPackaging, DockerPlugin)

lazy val Versions = new {
  val Akka           = "2.5.7"
  val AkkaHttp       = "10.0.11"
  val AkkaManagement = "0.7.1+3-b6686255+20180104-1248"
  val Scala          = "2.12.4"
}

scalaVersion := Versions.Scala

libraryDependencies ++= Vector(
  "com.typesafe.akka"             %% "akka-actor"                        % Versions.Akka,
  "com.typesafe.akka"             %% "akka-cluster"                      % Versions.Akka,
  "com.typesafe.akka"             %% "akka-http"                         % Versions.AkkaHttp,
  "com.typesafe.akka"             %% "akka-stream"                       % Versions.Akka,
  "com.lightbend.akka.discovery"  %% "akka-discovery-kubernetes-api"     % Versions.AkkaManagement,
  "com.lightbend.akka.management" %% "akka-management-cluster-bootstrap" % Versions.AkkaManagement
)
