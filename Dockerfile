FROM openjdk:20
EXPOSE 9090
ADD ./app.jar  PropertyMarket.jar
ENTRYPOINT ["java", "-jar", "/PropertyMarket.jar"]