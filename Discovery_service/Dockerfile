FROM java:8
FROM maven:alpine
# image layer
WORKDIR /app/Discovery_service
# Image layer: with the application
COPY ./Discovery_service /app/Discovery_service
RUN mvn -v
RUN mvn clean install -DskipTests
ENTRYPOINT ["java","-jar","/app/Discovery_service/target/Discovery_service-0.0.1-SNAPSHOT.jar"]