FROM openjdk:8
ADD target/my-maven-docker-project.jar my-maven-docker-project.jar
ENTRYPOINT ["java", "-jar","todo-mjd.jar"]
EXPOSE 8080