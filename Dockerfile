FROM gradle:latest as builder
WORKDIR /home/gradle/project
ADD src /home/gradle/project/src
COPY build.gradle pom.xml /home/gradle/project/
RUN gradle build --no-daemon

FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
