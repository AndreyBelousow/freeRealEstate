FROM maven:3.6.0-jdk-8-alpine

COPY . /myapp

WORKDIR /myapp

RUN cat /myapp/runner.sh

#ENTRYPOINT ["java", "-jar", "/myapp/target/*.jar"]