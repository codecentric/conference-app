<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

	<div class="jumbotron jumbotron-special">
	  <div class="container">
	    <div class="panel panel-default">
	      <div class="panel-body">
	        <h2><spring:message code="header.title" text="Open Space Software Development @ JavaLand 2015"/></h2>
	        <spring:message code="home.text" text="Can we as a (un)conference ship a working product 
		        from the first hour to the last hour and that is usable by real users from the very get-go? 
		        Are we really that agile? The questions we are asking are: Can we ship working product? 
		        Can we ship clean code? Can we run our agile practices to the max?"/>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="container">
	  <div class="row">
	    <div class="col-md-4">
	      <h2>Development</h2>
	      <p>Das Git-Repository aus GitHub clonen:
              <a href="https://github.com/codecentric/conference-app">
                  https://github.com/codecentric/conference-app</a><br>
              <a href="http://osswdev.codecentric.de/artifactory">Artifact Repository</a>
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
