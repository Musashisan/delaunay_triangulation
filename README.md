# Delaunay triangulation

Information: [Delaunay triangulation](https://en.wikipedia.org/wiki/Delaunay_triangulation)

The application generates random 2D points and calculates the corresponding Delaunay triangulation.
Then draws the triangulation using [Processing](https://processing.org/).

Execution sample:

_work in progress_


## Howto build ##
----
Requirements:
 * Latest stable [Oracle JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
 * Latest stable [Apache Maven](https://maven.apache.org/download.cgi)

Console commands:
 ```
 cd delaunay_triangulation
 mvn clean package assembly:single
 java -jar target/delaunay-triangulation-1.0-SNAPSHOT-jar-with-dependencies.jar
 ```
