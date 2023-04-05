#Run
FROM openjdk:17
MAINTAINER Sylvia(Yiping) Zhang
VOLUME /tmp
ADD target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]


#Maven Build
#FROM maven:3.8.3-openjdk-17-slim AS builder
#COPY pom.xml /app/
#COPY src /app/src
#RUN --mount=type=cache,target=/root/.m2 mvn -f /HW1V2/pom.xml clean package -DskipTests
#
##Run
#FROM openjdk:17
#COPY --from=builder /app/target/HW1V2-0.0.1-SNAPSHOT.jar a1-app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "a1-app.jar"]