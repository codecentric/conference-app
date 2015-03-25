<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="de.codecentric.util.TwitterLinkCreator"%>
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
			<form:form commandName="feedbackFormData" method="POST" class="form-horizontal">
			  <div class="form-group">
			    <label for="author" class="col-sm-2 control-label">Name</label>
			    <div class="col-sm-5">
			      <input type="text" class="form-control" id="name" name="name">
			      <form:errors class="form-error" path="name" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="text" class="col-sm-2 control-label">Feedback</label>
			    <div class="col-sm-5">
			      <textarea class="form-control" rows="3" id="feedbackContent" name="feedbackContent"></textarea>
			      <form:errors class="form-error" path="feedbackContent" />
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default" id="addFeedback">Send Feedback</button>
			    </div>
			  </div>
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
						    <p class="feedback-comment"><c:out value="${feedback.feedbackComment}" /></p>
                            <small class="username-and-timestamp"><c:out value="${feedback.userName}" /> - ${feedback.timestamp}</small>
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