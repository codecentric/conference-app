<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="org.ale.app.TwitterLinkCreator"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>

<div class="container-fluid">

<%@ include file="menu.jsp"%>

	<div class="well well-small">
		<h1 id="title"><spring:message code="feedback" text="Recent comments"/></h1>
	</div>
	
	<br style="clear: both;"/>

	<div class="row">
		<form:form commandName="feedbackFormData" method="POST">
			<div>Name:</div>
			<form:input maxlength="255" id="name" path="name" />
			<br />
			<div>Feedback:</div>
			<form:textarea  maxlength="4096" cols="30" rows="4" id="feedbackContent" path="feedbackContent" />
			<br />
			<br />
			<input type="submit" id="addFeedback" value="Send Feedback" class="btn btn-primary" />
		</form:form>
	</div>
	
	<div class="row">
		<div class="tabbable">
			<div class="tab-content">
				<table>
				<c:forEach items="${feedbackList}" var="feedback">
					<span style="font-style: bold; font-size: 1.2em;"><a href='timeslot?sessionId=${entry.sessionId}'>${entry.sessionTitle}</a></span>, <small>${entry.date}</small>
				    <blockquote>
					    <p>${feedback.feedbackComment}</p>
					    <small>${feedback.userName} - ${feedback.timestamp}</small>
				    </blockquote>
				</c:forEach>
				</table>
			</div>
		</div>
	</div>

<%@ include file="footer.html"%>

</div>
