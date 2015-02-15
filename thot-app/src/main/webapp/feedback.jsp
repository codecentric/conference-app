<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="org.ale.app.TwitterLinkCreator"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title"><spring:message code="feedback" text="Recent comments"/></h3>
	  </div>
	  <div class="panel-body">

		<div class="row-fluid">
			<form:form commandName="feedbackFormData" method="POST">
				<div>Name:</div>
				<form:input maxlength="255" id="name" path="name" size="50" />
				<br />
				<div>Feedback:</div>
				<form:textarea  maxlength="4096" cols="50" rows="4" id="feedbackContent" path="feedbackContent" />
				<br />
				<br />
				<input type="submit" id="addFeedback" value="Send Feedback" class="btn btn-primary" />
			</form:form>
		</div>
		
		<hr/>
		
		<div class="row-fluid">
			<div class="tabbable">
				<div class="tab-content">
					<table>
					<c:forEach items="${feedbackList}" var="feedback">
					    <span class="glyphicon glyphicon-envelope"></span>
					    <blockquote>
						    <p>${feedback.feedbackComment}</p>
						    <small>${feedback.userName} - ${feedback.timestamp}</small>
					    </blockquote>
					</c:forEach>
					</table>
				</div>
			</div>
		</div>
	  </div>
	</div>
</div>

<%@ include file="footer.html"%>