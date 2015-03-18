# Open Space Software Development

* Introduction https://www.codecentric.de/2015/03/18/javaland-openspace-software-development/

# Important Links

* Production Link **http://osswdev.codecentric.de**
* Continuous Delivery Build Pipeline **(offline)**
* Amazon EC2 Dashboard **(offline)**
* Sonar SQM **(offline)**
* Nexus Artifact Repository **(offline)**
* Twitter handle #hackerspace & #javaland

# Quickstart

```
cd monitoring
mvn clean install 
java -jar target/monitoring-1.0.0.jar

cd app
mvn clean install
java -jar target/conference-app-3.0.0.jar
```

## Open WebApp
http://localhost:8080

## Open Monitoring App
http://localhost:8888


# Environments 

| Environment         | Link          | 
| ------------------- |:-------------:|
| Test (offline)      | **(offline)** |
| Staging (offline)   | **(offline)** | 
| Production | **http://osswdev.codecentric.de** |
