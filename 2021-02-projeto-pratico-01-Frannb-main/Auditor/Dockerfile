FROM openjdk:11 

WORKDIR /auditor

# COPY . /auditor/
# RUN chmod +x ./gradlew
# RUN ./gradlew build

# ENTRYPOINT ["ls"]

ENTRYPOINT ["java", "-cp", "/auditor/build/libs/Auditor-1.0.jar:/auditor/libs/amqp-client-5.7.1.jar:/auditor/libs/slf4j-api-1.7.26.jar:/auditor/libs/algs4.jar", "auditor.Principal"]


# CMD [ "auditor/build/libs" ]
# RUN ["javac","-cp","/auditor/build/libs/Auditor-1.0.jar:/auditor/libs/amqp-client-5.7.1.jar:/auditor/libs/slf4j-api-1.7.26.jar:/auditor/libs/algs4.jar","/auditor/src/main/java/auditor/Principal.java"]
# CMD ["java", "-cp", "auditor/build/libs/Auditor-1.0.jar:/auditor/libs/amqp-client-5.7.1.jar:/auditor/libs/slf4j-api-1.7.26.jar:/auditor/libs/algs4.jar", "auditor.Principal"]
