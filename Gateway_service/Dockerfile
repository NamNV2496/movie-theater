FROM java:8
FROM maven:alpine
# image layer
WORKDIR /app/Gateway_service
# Image layer: with the application
COPY ./Gateway_service /app/Gateway_service
RUN mvn -v
RUN mvn clean install -DskipTests

ENTRYPOINT ["java", "-Deureka.client.serviceUrl.defaultZone=http://eureka:8761/eureka","-jar","/app/Gateway_service/target/Gateway_service-0.0.1-SNAPSHOT.jar"]