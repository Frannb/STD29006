FROM openjdk:11

WORKDIR /jogador2

# COPY . /jogador2/

# RUN chmod +x ./gradlew
# RUN ./gradlew jar

ENTRYPOINT ["java", "-cp", "/jogador2/build/libs/Jogador2-1.0.jar:/jogador2/libs/amqp-client-5.7.1.jar:/jogador2/libs/slf4j-api-1.7.26.jar", "receptor.Receptor"]


# CMD [ "jogador2/build/libs" ]
# RUN ["javac","-cp","/jogador2/build/libs/Jogador2-1.0.jar:/jogador2/libs/amqp-client-5.7.1.jar:/jogador2/libs/slf4j-api-1.7.26.jar","/jogador2/src/main/java/receptor/Receptor.java"]
# ENTRYPOINT ["java", "-cp", "jogador2/build/libs/Jogador2-1.0.jar:/jogador2/libs/amqp-client-5.7.1.jar:/jogador2/libs/slf4j-api-1.7.26.jar", "receptor.Receptor"]
