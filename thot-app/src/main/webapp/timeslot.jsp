<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>

<div class="container-fluid">

<%@ include file="menu.jsp"%>

		<div class="well well-small">

			<h2>${sessionTitle}</h2>
			<h4><spring:message code="editsession.description" text="Description"/></h4>
			<p>${sessionDescription}</p>
			<h4><spring:message code="editsession.proposedby" text="Proposed by"/></h4>
			<p>${sessionSpeaker}</p>
			<h4><spring:message code="editsession.location" text="Location"/></h4>
			<p>${location}</p>
			<h4><spring:message code="tableheader.starttime" text="Start time"/></h4>
			<p>${timeslot }</p>

			<c:if test="${sessionEditable}">
				<a class="btn btn-primary"
					href="<%= request.getContextPath() %>/editSession?sessionId=${sessionId}">
					<spring:message code="timeslot.editsessiondata" text="Edit session data"/></a>
			</c:if>

		</div>

		<br style="clear: both;" />

		<script type="text/JavaScript">
			function timedRefresh(timeoutPeriod) {
				setTimeout("location.reload(true);", timeoutPeriod);
			}
		</script>
	
		<%@ include file="footer.html"%>

	</div>