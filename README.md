# Open Space Software Development

Twitter handle #osswdev & #javaland

* Introduction https://www.codecentric.de/2015/03/18/javaland-openspace-software-development/

## Important Links

| Environment         | Link          | 
| ------------------- |:-------------:|
| Test (offline)      | **(offline)** |
| Staging (offline)   | **(offline)** | 
| Production | **http://osswdev.codecentric.de** |

Infrastructure Links

* Continuous Delivery Build Pipeline **http://54.93.92.96:8080/view/Pipeline/**
* Sonar SQM **http://54.93.92.96:9000/dashboard/index/1**
* Artifact Repository **http://54.93.92.96:8081/**
* Spring Boot Admin Client **http://54.93.206.225:8888/**
* Amazon EC2 Dashboard **(offline)**

## Quickstart

```
cd monitoring
mvn clean install 
java -jar target/monitoring-1.0.0.jar

cd app
mvn clean install
java -jar target/conference-app-3.0.0.jar
```

### Open WebApp
http://localhost:8080

### Open Monitoring App
http://localhost:8888

