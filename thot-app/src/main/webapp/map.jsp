<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>

<div class="container-fluid">

<%@ include file="menu.jsp"%>

	<div id="title" class="well well-small">
		<h2><spring:message code="map" text="map"/></h2> 
	</div>

	<br style="clear: both;"/>
	
	<div class="row">
		<div class="span10">
	    	<div class="content-heading">
	      		<img src="<%= request.getContextPath() %>/assets/img/parkinn-floorplan.jpeg"/>
	      	</div>
		</div>
	</div>
	
	<%@ include file="footer.html"%>

</div>