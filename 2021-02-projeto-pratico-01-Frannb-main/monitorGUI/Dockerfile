FROM openjdk:11

WORKDIR /app

COPY . /app/

RUN chmod +x ./gradlew
RUN ./gradlew jar

ENTRYPOINT ["java", "-cp", "build/libs/monitorGUI-1.0.jar:libs/amqp-client-5.7.1.jar:libs/slf4j-api-1.7.26.jar:libs/algs4.jar", "monitor.Principal"]