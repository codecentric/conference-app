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
		<h1>Speaker</h1>
	</div>

	<br style="clear: both;"/>

	<div class="row-fluid">
	<!-- commit form -->
	<form:form commandName="speakerFormData" action="speaker" method="POST">
		<form:hidden id="id" path="id"/>
        <div>Firstname:(*)</div>
        <form:input maxlength="255" id="foreName" path="foreName"/>
		<form:errors class="form-error" path="foreName" />
		<br />
        
        <div>Lastname:(*)</div>
        <form:input maxlength="255" id="lastName" path="lastName" />
		<form:errors class="form-error" path="lastName" />

		<br />

		<c:if test="${useMail}">
	        <div>E-Mail:</div>
	        <form:input maxlength="255" id="mail" path="mail" />
			<form:errors class="form-error" cssStyle="color:red" path="mail" />
		</c:if>

		<br />
		
        <div>Bio:</div>
        <form:textarea maxlength="255" id="bio" path="bio" />
		<form:errors class="form-error" path="bio" />

		<br />

		<div >
			<input type="submit" id="saveSpeaker" value="Save speaker" class="btn btn-primary" />
		</div>

	</form:form>
</div>

<%@ include file="footer.html"%>

</div>