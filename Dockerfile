FROM openjdk:11
EXPOSE 8080
ADD target/cartaodecredito-api-docker.jar cartaodecredito-api-docker.jar
ENTRYPOINT ["java","-jar","/cartaodecredito-api-docker.jar"]