OpenAPi:  <a href="localhost:8090/swagger-ui/index.html">localhost:8090/swagger-ui/index.html</a> <br>


Kjører Oracle19c i egen container port 1522<br>
Flyway<br>
Jooq<br>
Mockito<br>
MockMvc<Br>

mvn flyway:clean 
mvn flyway:migrate
 
RUN apt-get update && apt-get install curl -y

localhost:8090/actuator/health 
mvn clean install -Ddb.url=jdbc:oracle:thin:@localhost:1522/ORCLPDB1 -Dspring.datasource.url=jdbc:oracle:thin:@localhost:1522/ORCLPDB1 