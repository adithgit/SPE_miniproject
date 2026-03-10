# Use an official Java runtime as a parent image
FROM openjdk:27-ea-jdk-oracle

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
# Note: Ensure the name matches the JAR produced in your 'target' folder
COPY target/*.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

