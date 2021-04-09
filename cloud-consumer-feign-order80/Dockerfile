FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/cloud-consumer-feign-order80-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/app.jar"]