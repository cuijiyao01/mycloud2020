FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/cloud-provider-payment8002-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8002
ENTRYPOINT ["java","-jar","/app.jar"]