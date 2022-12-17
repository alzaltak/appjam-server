FROM eclipse-temurin:17-jre-focal

ADD build/libs/*.jar /app.jar

ENV TZ=Asia/Seoul

ENTRYPOINT ["java", "-jar", "/app.jar"]