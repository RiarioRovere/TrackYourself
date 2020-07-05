FROM java:8
EXPOSE 8080
ADD /target/demo-0.0.1-SNAPSHOT.jar docker.jar
ENTRYPOINT ["java", "-jar", "docker.jar"]