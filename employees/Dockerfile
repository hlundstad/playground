FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
CMD ["java","-jar","/app.jar"]
RUN apk add --update  curl && rm -rf /var/cache/apk/*
#RUN apk add vim wget curl nmap lsof bash bash-completion which
#CMD ["/bin/bash"]
EXPOSE 8090

#FROM openjdk:11-jre-slim
#VOLUME /tmp
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.lundstad.products.ProductServiceApplication"]