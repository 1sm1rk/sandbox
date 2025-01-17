FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY target/sandbox-0.0.1-SNAPSHOT.jar /opt/app/application.jar
CMD ["java", "-jar", "/opt/app/application.jar"]
