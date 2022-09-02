FROM openjdk:11

WORKDIR /jogador1

# COPY . /jogador1/

# RUN chmod +x ./gradlew
# RUN ./gradlew build

ENTRYPOINT ["java", "-cp", "/jogador1/build/libs/Jogador1-1.0.jar:/jogador1/libs/amqp-client-5.7.1.jar:/jogador1/libs/slf4j-api-1.7.26.jar", "receptor.Receptor"]


# CMD [ "jogador1/build/libs" ]
# RUN ["javac","-cp","/jogador1/build/libs/Jogador1-1.0.jar:/jogador1/libs/amqp-client-5.7.1.jar:/jogador1/libs/slf4j-api-1.7.26.jar","/jogador1/src/main/java/receptor/Receptor.java"]
# CMD ["java", "-cp", "/jogador1/build/libs/Jogador1-1.0.jar:/jogador1/libs/amqp-client-5.7.1.jar:/jogador1/libs/slf4j-api-1.7.26.jar", "receptor.Receptor"]
