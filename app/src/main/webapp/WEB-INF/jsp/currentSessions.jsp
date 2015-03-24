<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<%@ include file="news.jsp"%>

<div class="container-fluid">

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title"><spring:message code="current.sessions" text="Current Sessions"/></h3>
	  </div>
	  <div class="panel-body">

			<div class="tab-content">
			 	<div class="tab-pane active" id="current_sessions">
			 		<div class="row-fluid">
			 			<c:choose>
			 				<c:when test="${!currentSessions.isEmpty()}">
                                <c:set var="sessions" value="${currentSessions}" />
                                <%@ include file="sessionsTable_small.jsp"%>
                                <%@ include file="sessionsTable.jsp"%>
                            </c:when>
						<c:otherwise>
							<spring:message code="no.sessions.available" text="no.sessions.available" />
						</c:otherwise>
						</c:choose>
					</div>
			 	</div>
			</div>
		</div>
	</div>

</div>

<%@ include file="footer.html"%>
