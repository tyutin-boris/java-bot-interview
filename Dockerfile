FROM amazoncorretto:21.0.4

WORKDIR ./app

COPY ./target/java-bot-interview-0.0.2.jar ./app.jar

EXPOSE 9191

ENTRYPOINT ["java", "-jar", "app.jar"]
