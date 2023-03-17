# build stage
FROM maven:3.8.5-openjdk-18 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# package stage
FROM openjdk:18-jdk
ARG DATASOURCE_URL
ENV DATASOURCE_URL=${DATASOURCE_URL}
COPY --from=build /home/app/target/study-spring-2022-1.0-SNAPSHOT.jar /usr/local/lib/shipping_service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/shipping_service.jar"]
