FROM openjdk:17
LABEL maintainer="krya"
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

