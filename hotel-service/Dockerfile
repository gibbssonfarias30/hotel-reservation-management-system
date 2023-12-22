FROM openjdk:17-jdk-slim AS build

COPY target/hotel-service-0.0.1-SNAPSHOT.jar hotel-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/hotel-service-0.0.1-SNAPSHOT.jar"]