FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/cloud-eureka-server7001-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 7001
ENTRYPOINT ["java","-jar","/app.jar"]