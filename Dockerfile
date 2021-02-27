# base image from adopt openjdk
FROM adoptopenjdk/openjdk11:alpine-jre
# Refer to Maven build -> finalName
ARG JAR_FILE=target/ca-ms-product-0.0.1.jar
# cd /opt/app
WORKDIR /opt/app
# cp target/ca-ms-product-0.0.2.jar /opt/app/ca-ms-product-0.0.1.jar
COPY ${JAR_FILE} ca-ms-product-0.0.1.jar
# java -jar /opt/app/ms-person-0.0.1.jar
ENTRYPOINT ["java","-jar","ca-ms-product-0.0.1.jar"]