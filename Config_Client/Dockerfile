FROM java:8
FROM maven:alpine
# image layer
WORKDIR /app/Config_client
# Image layer: with the application
COPY ./Config_client /app/Config_client
RUN mvn -v
RUN mvn clean install -DskipTests

ENTRYPOINT ["java", "-Deureka.client.serviceUrl.defaultZone=http://eureka:8761/eureka","-jar","/app/Config_client/target/Config_client-0.0.1-SNAPSHOT.jar"]