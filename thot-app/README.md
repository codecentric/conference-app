## Quickstart

For running the app incl. the Spring Boot Admin client use the following commands.

```
# Start monitoring app
cd thot-monitoring
mvn clean install
java -jar target/thot-monitoring*.jar

# Start thot-app with environment configuration
cd thot-app
mvn clean install
java -jar -Dspring.config.location=config/production.properties target/thot-app*.jar
java -jar -Dspring.config.location=config/staging.properties target/thot-app*.jar
java -jar -Dspring.config.location=config/test.properties target/thot-app*.jar
```

For demo reasons we start the app three times with different ports. 
In your spring admin client web app you should see three versions of the thot app.

* http://localhost:8888

You can access the thot apps under:

| Environment         | Link          | 
| ------------------- |:-------------:|
| Test        | http://localhost:8080/thot |
| Staging     | http://localhost:8081/thot | 
| Production  | http://localhost:8082/thot |
| Monitoring  | http://localhost:8888/ |

