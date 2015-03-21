# Open Space Software Development

* Hashtags: #osswdev & #javaland
* Introduction: https://www.codecentric.de/2015/03/18/javaland-openspace-software-development/

## Important Links

| Environment         | Link          | 
| ------------------- |:-------------:|
| Production | **http://osswdev.codecentric.de** |
| Staging (offline)   | **(offline)** | 
| Test (offline)      | **(offline)** |

### Infrastructure Links

* Continuous Delivery Build Pipeline **http://osswdev.codecentric.de/jenkins/view/Pipeline/**
* SonarQube SQM **http://osswdev.codecentric.de/sonarqube/dashboard/index/1**
* Artifact Repository **http://osswdev.codecentric.de/artifactory**
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
