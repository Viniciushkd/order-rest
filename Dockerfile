FROM openjdk:8
ADD target/order-service.jar order-service.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "order-service.jar"]