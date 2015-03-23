<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

	<div class="jumbotron jumbotron-special">
	  <div class="container">
	    <div class="panel panel-default">
	      <div class="panel-body">
	        <h2><spring:message code="header.title" text="Open Space Software Development @ JavaLand 2015"/></h2>
	        <spring:message code="home.text" text="Auf Konferenzen wird viel über Methoden und Technologien gesprochen.
	        Wir möchten herausfinden, wie sich Dinge, die wir für richtig und wertvoll halten, in der Praxis anfühlen.
	        Daher laden wir euch zum codecentric OpenSpace Development ein – ein sicherer Raum, in dem unter
	        realitätsnahen Bedingungen experimentiert und gelernt werden kann."/>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="container">
        <div class="row">
            <div class="col-md-4">
                <h2>Einfach mitmachen</h2>
                <h3>Wie?</h3>
                <p>Helft uns diese Applikation weiter zu entwickeln. Dazu könnt Ihr Eure Laptop und Eure
                    Entwicklungsumbenung nutzen. Oder Ihr paired mit einem anderen Teilnehmer oder einem unserer
                    Kollegen. Alterniv könnt Ihr auch gerne unsere Product Owner bei der Erstellung und Priosrisierung
                    der nächsten Backlogeinträge helfen. Oder Ihr gebt Feedback zur Anwendung. Nuzt einfach die Feedback
                    Funktionalität hier in der Applikation oder noch besser kommt einfach bei uns vorbei.
                </p>
                <h3>Wo?</h3>
                <p>Ihr findet uns vom Eingang kommend links (Nummer 104), neben der Lecture Area.</p>
            </div>
            <div class="col-md-8">
                <h2>Erste Schritte</h2>
                <p>Das Git-Repository aus GitHub clonen:
                    <a href="https://github.com/codecentric/conference-app">
                        https://github.com/codecentric/conference-app</a></p>
                <p>Das Artifect Repository findet Ihr unter
                    <a href="http://osswdev.codecentric.de/artifactory">http://osswdev.codecentric.de/artifactory</a></p>
                <p>Intressant sind sowohl die <a href="http://osswdev.codecentric.de/jenkins/view/Pipeline/">
                    Continuous Delivery Build Pipeline</a> als auch der
                    <a href="http://osswdev.codecentric.de/sonarqube/dashboard/index/1">SonarQube SQM</a>.</p>
                <p>Den aktullen Status der laufen Produktionsinstanz sieht man im
                    <a href="http://osswdev.codecentric.de/admin">Spring Boot Admin Client</a>.
                </p>
            </div>
        </div>
	  <div class="row">
	    <div class="col-md-4">
	      <h2>Developer Quickstart</h2>
	      <p><code>cd monitoring
              mvn clean install
              java -jar target/monitoring-1.0.0.jar

              cd app
              mvn clean install
              java -jar target/conference-app-3.0.0.jar</code>

              Dann findes sich die WebApp unter <br> http://localhost:8080 <br> und die Monitoring Appl unter <br>
              http://localhost:8888
          </p>
	    </div>
	    <div class="col-md-4">
	      <h2>Craftsmanship</h2>
	      <p>
              <a href="http://osswdev.codecentric.de/jenkins/view/Pipeline/">Continuous Delivery Build Pipeline</a><br>
              <a href="http://osswdev.codecentric.de/sonarqube/dashboard/index/1">SonarQube SQM</a>
          </p>
	   </div>
	    <div class="col-md-4">
	      <h2>Operations</h2>
	      <p>
              <a href="http://osswdev.codecentric.de/admin">Spring Boot Admin Client</a>
          </p>
	    </div>
	  </div>
	</div>

<%@ include file="footer.html"%>
