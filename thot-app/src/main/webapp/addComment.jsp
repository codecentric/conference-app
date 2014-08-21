<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="well well-small">
		<h2>Comments for session:</h2>
	    <h3>${sessionTitle}</h3> 
	</div>

	<br style="clear: both;"/>

	<div class="row-fluid">
		<!-- commit form -->
		<form:form commandName="commentFormData" method="POST">
	        <div>Name:(*)</div>
	        <form:input maxlength="255" id="author" path="author"/>
			<form:errors class="form-error" path="author" />
			<br />
	        
	        <div>Comment:</div>
	        <form:textarea maxlength="255" id="text" path="text" />
			<form:errors class="form-error" path="text" />
	
			<br />
			
			<input class="btn btn-primary" type="submit" id="addComment" value="Add comment" />
	
		</form:form>
	</div>

	<%@ include file="footer.html"%>

</div>