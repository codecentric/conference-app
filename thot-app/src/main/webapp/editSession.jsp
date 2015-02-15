<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>

<div class="container-fluid">

<%@ include file="menu.jsp"%>

	<div class="well well-small">
		<h1><spring:message code="editsession.sessiondata" text="Topic"/></h1>
	</div>
	
	<div class="row">
		<form:form commandName="sessionDataFormData" method="POST" action="editSession">
	    <div>
	    	<spring:message code="editsession.topic" text="Topic"/>:(*)</div>
		        <form:input maxlength="255" id="title" path="title" />
				<form:errors class="form-error" path="title" />
		        <div><spring:message code="editsession.proposedby" text="Proposed by"/>:</div>
		        <form:input maxlength="255" id="speaker" path="speaker" />
				<form:errors class="form-error" path="speaker" />
				<br />
		        <div><spring:message code="editsession.description" text="Description"/>:</div>
		        <form:textarea  maxlength="4096" cols="30" rows="4" id="description" path="description" />
				<form:errors class="form-error" path="description" />
				<br />
				<br />
				<spring:message code="editsessions.savesession" var="SaveSession"/>
				<input class="btn btn-primary" type="submit" id="saveSession" value="${SaveSession}" />
				<form:hidden path="date"/>
				<form:hidden path="start"/>
				<form:hidden path="end"/>
				<form:hidden path="location"/>
            <c:if test="${!newSession}">
                <input name="sessionId" type="hidden" value="${sessionDataFormData.sessionId}" />
            </c:if>
        </form:form>
		</div>

<%@ include file="footer.html"%>

<script type="text/JavaScript">
	$(document).ready(function() {
		$(".date").change(function(){
			$.getJSON('./addSession/timeslotsPerDay?day=' + $(this).val(), function(timeslots) {
				var items = [];

				$.each(timeslots, function(key, value) {
				    items.push('<option value="' + key + '">' + value + '</option>');
				  });
				
				$("#start").empty();

				$("#start").append(items.join(''));
			});
		});
	});
</script>

</div>
