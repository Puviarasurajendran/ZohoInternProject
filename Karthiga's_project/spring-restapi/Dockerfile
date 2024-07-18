# Use an official Tomcat image
FROM tomcat:9.0-jdk17-temurin

# Set the working directory inside the container
WORKDIR /usr/local/tomcat

RUN sed -i 's|http://ports.ubuntu.com|http://archive.ubuntu.com|g' /etc/apt/sources.list
# Update package list and install necessary tools
RUN apt-get update && apt-get install -y \
    iputils-ping \
    mysql-client

# Clean up
RUN apt-get clean

# Copy the packaged WAR file into the Tomcat webapps directory
COPY spring-restapi.war /usr/local/tomcat/webapps/spring-restapi.war

# Expose the port that Tomcat runs on
EXPOSE 8080


# Start Tomcat server
CMD ["catalina.sh", "run"]
