FROM openjdk:8-alpine

COPY build/libs/zeinholistic-api-1.0.0.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]

LABEL maintainer="hey.mudassir@gmail.com"
