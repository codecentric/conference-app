## Quickstart

Prerequisites:

```
# MySQL in einem Docker Container starten
docker run --name javalandDB -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=app -p 3306:3306 -d mysql
```

For running the app incl. the Spring Boot Admin client use the following commands.

```
# Start monitoring app
cd monitoring
mvn clean install
java -jar target/monitoring*.jar

# Start conference-app with environment configuration
cd conference-app
mvn clean install
java -jar -Dspring.config.location=config/production.properties target/conference-app*.war
java -jar -Dspring.config.location=config/staging.properties target/conference-app*.war
java -jar -Dspring.config.location=config/test.properties target/conference-app*.war
```

For demo reasons we start the app three times with different ports. 
In your spring admin client web app you should see three versions of the conference app.

* http://localhost:8888

You can access the conference apps under:

| Environment         | Link          | 
| ------------------- |:-------------:|
| Test        | http://localhost:8080 |
| Staging     | http://localhost:8081 | 
| Production  | http://localhost:8082 |
| Monitoring  | http://localhost:8888 |
