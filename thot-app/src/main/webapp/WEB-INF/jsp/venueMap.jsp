<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title"><spring:message code="map" text="Map"/></h3>
	  </div>
	  <div class="panel-body">
	
		<div class="row">
			<div class="span10">
		    	<div class="content-heading">
		      		<img src="<%= request.getContextPath() %>/img/javaland2014-location.jpg"/>
		      	</div>
			</div>
		</div>
	
	</div>
  </div>

</div>

	
	<%@ include file="footer.html"%>