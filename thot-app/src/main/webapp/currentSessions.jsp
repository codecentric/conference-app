<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container-fluid">
	
		<div class="well well-small">
			<h1 id="title">
				<spring:message code="current.sessions" text="Current Sessions" />
			</h1>
		</div>

		<br style="clear: both;" />

		<div class="tab-content">
		 	<div class="tab-pane active" id="current_sessions">
		 		<div class="row-fluid">
		 			<c:choose>
		 				<c:when test="${!currentSessions.isEmpty()}">
							<table class="table table-striped">
								<%@ include file="currentSessions_tableheader.html"%>
								<tbody>
									<c:forEach items="${currentSessions}" var="session">
				                        <c:url value="comments" var="url" scope="page">
				                            <c:param name="sessionId" value="${session.getId()}" />
				                        </c:url>
										<tr class="sessions" data-link="${url}">
											<td>${session.date}</td>
											<td>${session.start}</td>
											<td>${session.end}</td>
											<td>${session.title}</td>
											<td>${session.author}</td>
											<td>${session.location}</td>
											<td>${session.type.label}</td>
											<td><a class="btn btn-primary" href='comments?sessionId=${session.id}'>Comment</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</c:when>
					<c:otherwise>
						<spring:message code="no.sessions.available" text="no.sessions.available" />
					</c:otherwise>
					</c:choose>
				</div>
		 	</div>
		 	
			 <c:forEach items="${sessionMap}" var="entry" varStatus="status">
			 	<div class="tab-pane" id="date${status.index}">

					<div class="row-fluid">
						<table class="table table-striped">
							<%@ include file="schedule_tableheader.html"%>
							<tbody>
								<c:forEach items="${entry.value}" var="session">
			                        <c:url value="comments" var="url" scope="page">
			                            <c:param name="sessionId" value="${session.id}" />
			                        </c:url>
									<tr class="sessions" data-link="${url}">
										<td>${session.date}</td>
										<td>${session.start}</td>
										<td>${session.end}</td>
										<td>${session.title}</td>
										<td>${session.author}</td>
										<td>${session.location}</td>
										<td><a class="btn btn-primary" href='addComment?sessionId=${session.id}'>Comment</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			 	</div>
			</c:forEach>
		</div>

    <script type="text/JavaScript">
    <!--
        function initTab() {
            $('#daysTab a:last').tab('show');
        }
    //   -->
    </script>
    <%@ include file="footer.html"%>
    
</div>