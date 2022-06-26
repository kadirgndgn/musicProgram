FROM openjdk:11
ADD target/musicProgram-0.0.1-SNAPSHOT.jar musicProgram-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "musicProgram-0.0.1-SNAPSHOT.jar" ]