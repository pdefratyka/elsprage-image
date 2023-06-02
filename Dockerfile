FROM openjdk:17.0.1-jdk-slim

ARG JAR_FILE=target/elsprage-image.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]