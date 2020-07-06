FROM java:8
EXPOSE 8080
EXPOSE 27017
ENV MONGO_USER 
ADD /target/demo-0.0.1-SNAPSHOT.jar docker.jar
ENTRYPOINT ["java", "-jar", "docker.jar"]