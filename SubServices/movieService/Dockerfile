FROM java:8
FROM maven:alpine
# image layer
WORKDIR /app/SubServices/movieService
# Image layer: with the application
COPY ./SubServices/movieService /app/SubServices/movieService
RUN mvn -v
RUN mvn clean install -DskipTests

ENTRYPOINT ["java", "-Deureka.client.serviceUrl.defaultZone=http://eureka:8761/eureka","-jar","/app/SubServices/movieService/target/movieService-0.0.1-SNAPSHOT.jar"]