FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ARG JAR_FILE=shop-service/target/*.jar
ARG JAR_FILE=shop-service/target/*.jar
#COPY ${JAR_FILE} app.jar
COPY shop-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
RUN apk add vim wget curl nmap lsof bash bash-completion which
CMD ["/bin/bash"]