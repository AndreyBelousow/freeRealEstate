FROM openjdk:8u181-jdk-alpine3.8

COPY target/freerealestate-0.0.1-SNAPSHOT.jar /myapp/server.jar

ENTRYPOINT ["java", "-jar", "/myapp/server.jar"]