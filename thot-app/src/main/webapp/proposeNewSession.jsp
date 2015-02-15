<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>

<div class="container-fluid">

<%@ include file="menu.jsp"%>

	<div class="well well-small">
		<h1 title="proposeNewSession">Propose new Session - Anytime / Anywhere</h1>
	</div>
	
	<div class="row">
		<form:form commandName="sessionDataFormData" method="POST" action="proposeNewSession">
	    <div>
		        <h3>Session for Day - ${day}</h3><br/>
	
		    	<spring:message code="editsession.topic" text="Topic"/>:(*)</div>
		        <form:input maxlength="255" id="title" path="title" />
				<form:errors class="form-error" path="title" />
		        <div><spring:message code="editsession.proposedby" text="Proposed by"/>:</div>
		        <form:input maxlength="255" id="speaker" path="speaker" />
		        <div>Location</div>
		        <form:input maxlength="255" id="speaker" path="location" />
		        
		        <div>Start (hh:mm)</div>
		        <form:input maxlength="255" id="speaker" path="start" />
		        <form:errors class="form-error" path="start" />

		        <div>End (hh:mm)</div>
		        <form:input maxlength="255" id="speaker" path="end" />
		        <form:errors class="form-error" path="end" />
		        
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
