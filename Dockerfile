FROM openjdk:21-jdk

RUN mkdir app
COPY config.yml app
COPY target/dropwizard.jar app
EXPOSE 8080

WORKDIR app
CMD ["java", "-jar", "dropwizard.jar", "server", "config.yml"]