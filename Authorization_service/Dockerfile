FROM java:8
FROM maven:alpine
# image layer
WORKDIR /app/Authorization_service
# Image layer: with the application
COPY ./Authorization_service /app/Authorization_service
RUN mvn -v
RUN mvn clean install -DskipTests

ENTRYPOINT ["java", "-Deureka.client.serviceUrl.defaultZone=http://eureka:8761/eureka","-jar","/app/Authorization_service/target/Authorization_service-0.0.1-SNAPSHOT.jar"]