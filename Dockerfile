FROM java:8
EXPOSE 8080
EXPOSE 27017
ADD /target/demo-0.0.2-SNAPSHOT.jar docker.jar
ENTRYPOINT ["java", "-jar", "docker.jar"]