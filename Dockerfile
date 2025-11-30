# Use a lightweight OpenJDK base image
#FROM openjdk:17
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
ARG JAR_FILE=target/employeeexample-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expose the port your application runs on (default for Spring Boot is 8080)
EXPOSE 8080

# Define the command to run your Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]