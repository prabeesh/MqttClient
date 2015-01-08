name := "MQTTScalaClinet"

version := "0.2.0"

scalaVersion := "2.10.3"

libraryDependencies += "org.eclipse.paho" % "mqtt-client" % "0.4.0"

libraryDependencies += "com.jsuereth" %% "scala-arm" % "1.3"

resolvers += "MQTT Repository" at "https://repo.eclipse.org/content/repositories/paho-releases/"
