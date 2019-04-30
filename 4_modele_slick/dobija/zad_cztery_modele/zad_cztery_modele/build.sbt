name := "zad_cztery_modele"
 
version := "1.0" 
      
lazy val `zad_cztery_modele` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( ehcache , ws , specs2 % Test , guice , "mysql" % "mysql-connector-java" % "5.1.44" )
libraryDependencies += "com.typesafe.play" %% "play-slick" % "3.0.3"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )



      