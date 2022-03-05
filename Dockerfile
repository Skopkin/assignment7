FROM openjdk:8
ADD target/todo-mjd.jar todo-mjd.jar
ENTRYPOINT ["java", "-jar","todo-mjd.jar"]
EXPOSE 8082