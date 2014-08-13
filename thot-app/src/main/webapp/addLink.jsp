<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<!--/span-->
	<div class="well well-small">
		<h2>Links for session:</h2>
	    <h3>${sessionTitle}</h3> 
	</div>

	<br style="clear: both;"/>

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
</div></div>

<%@ include file="footer.html"%>
