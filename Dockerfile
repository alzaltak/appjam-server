FROM openjdk:17.0.1-jdk-slim

COPY ./build/libs/*.jar app.jar

ENV TZ=Asia/Seoul
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]