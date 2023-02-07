FROM openjdk:17

EXPOSE 8080

WORKDIR /applications

COPY target/F1powerApp-0.0.1-SNAPSHOT.jar /applications/f1powerapp-application.jar

ENTRYPOINT ["java", "-jar", "f1powerapp-application.jar"]
