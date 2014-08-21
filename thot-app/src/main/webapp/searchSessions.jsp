<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="org.ale.app.TwitterLinkCreator"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="well well-small">
		<h1><spring:message code="search" text="search"/></h1>
	</div>
	
	<br style="clear: both;"/>

	<div class="row-fluid">
		<form:form commandName="searchFormData" method="POST">
			<div>Author Name:</div>
			<form:input maxlength="255" id="name" path="name" />
			<br />
			<br />
			<input type="submit" id="searchSessions" value="Search" class="btn btn-primary" />
		</form:form>
	</div>

		<div class="row-fluid">
			<div class="tabbable">
				<div class="tab-content">

					<table class="table table-striped">
						<%@ include file="searchresults_tableheader.html"%>
						<tbody>
							<c:forEach items="${sessionsList}" var="session">
								<c:url value="comments" var="url" scope="page">
									<c:param name="sessionId" value="${session.id}" />
								</c:url>
								<tr class="sessions" data-link="${url}">
									<td>${session.author}</td>
									<td>${session.date}</td>
									<td>${session.start}</td>
									<td>${session.end}</td>
									<td>${session.title}</td>
									<td>${session.location}</td>
									<td>${session.type}</td>
									<td><a class="btn btn-primary"
										href='comments?sessionId=${session.id}'>Comment</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<%@ include file="footer.html"%>

</div>
