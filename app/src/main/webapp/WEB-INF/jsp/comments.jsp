<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body onload="JavaScript:timedRefresh(20000);">
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <div class="row-fluid">
		  <div class="col-xs-6 col-md-6">
		  	<h5><span class="label label-info">Description</span> ${session.title}</h5>
		  </div>
		  <div class="col-xs-6 col-md-6">
		  	<span class="glyphicon glyphicon-thumbs-up pull-right" aria-hidden="true"></span>
		  </div>
		</div>
		<div class="row-fluid">
		  <div class="col-xs-3 col-md-2">
		  	<h5><span class="label label-info">Start time</span> ${session.start}</h5>
		  </div>
		  <div class="col-xs-3 col-md-2">
			<h5><span class="label label-info">End time</span> ${session.end}</h5>	
			<c:if test="${sessionEditable}">
				<a class="btn btn-primary"
					href="<%= request.getContextPath() %>/editSession?sessionId=${sessionId}">Edit
					session data</a>
			</c:if>	  
		  </div>
		  <div class="col-xs-4 col-md-4">
			<h5><span class="label label-info">Proposed by</span> ${sessionSpeaker}</h5>		  
		  </div>
		  <div class="col-xs-4 col-md-4">
		  	<h5><span class="label label-info">Location</span> ${location}</h5>
		  </div>
		</div>
	  </div>
	  <div class="panel-body">

		<div class="row-fluid">
			
			<h3>Audience comments</h3>
			
			<div style="float: right;">
				<a class="btn btn-primary"
					href="<%= request.getContextPath() %>/addComment?sessionId=<%= request.getParameter("sessionId")%>">Add
					Comment</a>
			</div>

			<table id="comments" class="table table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Comment</th>
						<th>Date</th>
						<th>Twitter</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${comments}" var="comment">
						<tr>
							<td>${comment.author}</td>
							<td>${comment.text}</td>
							<td><fmt:formatDate value="${comment.date}" type="both" dateStyle="short" timeStyle="short" /></td>
							<td><a href="http://twitter.com/?status=Neuer Kommentar: ${comment.text} - http://bit.ly/conference-app-2015 - %23osswdev %23javaland15 via @OSSWDEV">Tweet comment</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="row-fluid">
		
			<h3>Links to additional resources</h3>
		
			<div style="float: right;">
				<a class="btn btn-primary"
					href="<%= request.getContextPath() %>/addLink?sessionId=<%= request.getParameter("sessionId")%>&title=${session.title}">Add
					Link</a>
			</div>

			<table id="link" class="table table-striped">
				<thead>
					<tr>
						<th>Link</th>
						<th>Comment</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${links}" var="link">
						<tr>
							<td><a href="${link.link}">${link.link}</a></td>
							<td>${link.comment}</td>
							<td><fmt:formatDate value="${link.date}" type="both"
									dateStyle="short" timeStyle="short" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
  	  </div>
	</div>
	
</div>

<%@ include file="footer.html"%>
