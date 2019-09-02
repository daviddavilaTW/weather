name := "WeatherProducer"

val kafkaVersion = "2.3.0"

lazy val commonSettings = Seq(

  version := "0.1",
  scalaVersion := "2.12.0",
  libraryDependencies ++= Seq(
    "org.apache.kafka" %% "kafka" % kafkaVersion
    )

)

lazy val producers = (project in file("producers"))
  .settings(
    commonSettings,
    assemblyJarName in assembly := s"${name.value.replace(' ','-')}-${version.value}.jar",
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
  )