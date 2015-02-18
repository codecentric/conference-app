<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="org.cc.thot.util.TwitterLinkCreator"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title"><spring:message code="search" text="Author Search"/></h3>
	  </div>
	  <div class="panel-body">

		<div class="row-fluid">
			<form:form commandName="searchFormData" method="POST">
				<div><spring:message code="search.authorname" text="Author Name"/>:</div>
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
									<td>${session.type.label}</td>
									<td><a class="btn btn-primary"
										href='comments?sessionId=${session.id}'>Comment</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
  </div>

</div>

<%@ include file="footer.html"%>