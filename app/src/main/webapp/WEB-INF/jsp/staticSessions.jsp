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
	    <h3 class="panel-title"><spring:message code="sessions" text="Conference Schedule"/>
	    <small><spring:message code="session.day.selection" text="session.day.selection" /></small></h3>
	  </div>
	  <div class="panel-body">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#current_sessions" data-toggle="tab"><spring:message code="current_session" text="current sessions" /></a></li>
			<c:forEach items="${sessionDays}" var="day" varStatus="status">
				<li><a href="#date${status.index}" data-toggle="tab"> ${day} </a></li>
			</c:forEach>
		</ul>

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
						<br/>
						<spring:message code="no.sessions.available" text="no.sessions.available" />
					</c:otherwise>
					</c:choose>
				</div>
		 	</div>

			 <c:forEach items="${sessionMap}" var="entry" varStatus="status">
			 	<div class="tab-pane" id="date${status.index}">

					<div class="row-fuid">
                        <c:set var="sessions" value="${entry.value}" />
                        <%@ include file="sessionsTable_small.jsp"%>
                        <%@ include file="sessionsTable.jsp"%>
					</div>
			 	</div>
			</c:forEach>
		</div>
	  </div>
	</div>

</div>

<%@ include file="footer.html"%>
