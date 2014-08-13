<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<!--/span-->
	<div class="well well-small">
	<h1>Session Data</h1>
	</div>
	
	<div class="row-fluid">
	<form:form commandName="sessionDataFormData" method="POST">
	
    <div>Topic:(*)</div>
        <form:input maxlength="255" id="title" path="title" />
		<form:errors class="form-error" path="title" />
        <div>Proposed by:</div>
        <form:input maxlength="255" id="speaker" path="speaker" />
		<form:errors class="form-error" path="speaker" />
		<br />
        <div>Description:</div>
        <form:textarea  maxlength="4096" cols="30" rows="4" id="description" path="description" />
		<form:errors class="form-error" path="description" />
		<br />
        
		<br />
		
		<input type="submit" id="saveSession" value="Save Session" />

	</form:form>
</div>
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
