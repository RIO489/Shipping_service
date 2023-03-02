FROM openjdk:18-jdk
COPY . .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/target/study-spring-2022-1.0-SNAPSHOT.jar"]