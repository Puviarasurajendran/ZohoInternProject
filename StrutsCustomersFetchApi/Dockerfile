# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged WAR file into the container at /app
COPY StrutsCustomersFetchApi.war /app/StrutsCustomersFetchApi.war

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application when the container starts
CMD ["java", "-jar", "/app/StrutsCustomersFetchApi.war"]
