FROM openjdk:17-alpine
ADD target/sample-tracking-api-1.0.1.jar order-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sample-tracking-api.jar"]