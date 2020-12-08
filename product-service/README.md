mvn clean install  
mvn spring-boot:run 

target/api-spec/demo-api-v1.json <br>
mvn jib:dockerBuild  //

Bygge via pom filen og push til docker hub (krever  hlundstad/)
mvn compile jib:build 

Bygge via pom fil ved Docker Daemon:
 mvn jib:dockerBuild 
 
 For å laste inn images (for ps images):
  docker pull hlundstad/shop-service
 
 Opp med containers:
  docker-compose up 
  
  Kjør testene:
  docker-compose -f docker-compose.yml -f component-test/component-test-compose.yml up component-test 



