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
	    <h3 class="panel-title">Links for session: <small>${sessionTitle}</small></h3>
	  </div>
	  <div class="panel-body">
	
		<div class="row-fluid">
		<!-- commit form -->
		<form:form commandName="linkFormData" method="POST">
	        <div>URL:(*)</div>
	        <form:input maxlength="255" id="url" path="url"/>
			<form:errors class="form-error" path="url" />
			<br />
	        
	        <div>Comment:</div>
	        <form:textarea maxlength="255" id="comment" path="comment" />
			<form:errors class="form-error" path="comment" />
	
			<br />
			
			<input type="submit" id="addLink" value="Add link" />
	
		</form:form>
	  </div>
	</div>
  </div>
</div>

<%@ include file="footer.html"%>
