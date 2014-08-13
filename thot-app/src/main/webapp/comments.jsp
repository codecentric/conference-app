<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body onload="JavaScript:timedRefresh(20000);">
	<%@ include file="menu.jsp"%>

	<div class="container-fluid">

		<div style="float: right;">
			<c:if test="${sessionEditable}">
				<a class="btn btn-primary"
					href="<%= request.getContextPath() %>/editSession?sessionId=${sessionId}">Edit
					session data</a>
			</c:if>
		</div>

		<!--/span-->
		<div class="well well-small">

			<!-- 
	<h4>For session at location: ${sessionLocationAndTimeSlot}</h4>
-->
			<h2>${sessionTitle}</h2>
			<h4>Description</h4>
			<p>${sessionDescription}</p>
			<h4>Proposed by</h4>
			<p>${sessionSpeaker}</p>
			<h4>Location</h4>
			<p>${location}</p>
			<h4>Start time</h4>
			<p>${timeslot }</p>
		</div>

		<br style="clear: both;" />

		<div class="row-fluid">
			<div style="float: right;">
				<a class="btn btn-primary"
					href="<%= request.getContextPath() %>/addComment?sessionId=<%= request.getParameter("sessionId")%>&title=${sessionTitle}">Add
					Comment</a>
			</div>

			<table id="comments" class="table table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Comment</th>
						<th>Date</th>
						<th colspan="2">Rating</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${comments}" var="comment">
						<tr>
							<td>${comment.processedAuthor}</td>
							<td>${comment.text}</td>
							<td><fmt:formatDate value="${comment.date}" type="both"
									dateStyle="short" timeStyle="short" /></td>
									
									<td class="rating" data-rating="${comment.rating}">
										<img src='assets/img/thumb${comment.rating}.png' title='Rating: ${comment.rating}' alt='${comment.rating}'>
									</td>
							<td><a href="http://twitter.com/?status=Neuer Kommentar: ${comment.text} - http://bit.ly/xdde-12-prod - %23osswdev %23xdde12 via @OSSWDEV">Kommentar twittern</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="row-fluid">
			<div style="float: right;">
				<a class="btn btn-primary"
					href="<%= request.getContextPath() %>/addLink?sessionId=<%= request.getParameter("sessionId")%>&title=${sessionTitle}">Add
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

	<script type="text/JavaScript">
	<!--
		function timedRefresh(timeoutPeriod) {
			setTimeout("location.reload(true);", timeoutPeriod);
		}
	

		
	//   -->
	</script>

	<%@ include file="footer.html"%>