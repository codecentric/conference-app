<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body onload="JavaScript:initTab();">
<%@ include file="menu.jsp"%>


<div class="container-fluid">


	<!--/span-->
	<div class="well well-small">
	<h1><spring:message code="marketplace" text="marketplace"/></h1>
	</div>
<!-- 	
	<div style="float: right;">
			<a class="btn btn-primary" href="<%= request.getContextPath() %>/editSession">Add OpenSpace</a>
	</div>
-->
	<br style="clear: both;"/>


	<div class="row-fluid">
		<div class="tabbable">
			<ul class="nav nav-tabs" id="daysTab">
				<c:forEach items="${days}" var="day">
					<li><a href="#${day.getShortName()}" data-toggle="tab">${day.getShortName()}</a></li>
				</c:forEach>			
				<!--  li class="active"></li -->
			</ul>
			
			<div class="tab-content">	
			<c:forEach items="${days}" var="day">
				<div class="tab-pane" id="${day.getShortName()}">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Location</th>
								<c:forEach items="${allTimeslots.get(day.getShortName())}" var="timeslot">
									<th>${timeslot.toString()}</th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${allSessions.get(day.getShortName())}" var="entry">
							<tr>
								<td>${entry.key}</td>
								<c:forEach items="${allTimeslots.get(day.getShortName())}" var="timeslot">
								<c:set var="session" value="${entry.value.get(timeslot.getStart())}"></c:set>
								<c:choose>
								<c:when test="${session != null}">
								<td><a href='comments?sessionId=${session.id}'>${session.title}</a></td>
								</c:when>
								<c:otherwise>
									<td><i>Available slot</i></td>
								</c:otherwise>
								</c:choose>
								</c:forEach>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</c:forEach>
					
			</div>
		</div>
	</div>
</div>

    <script type="text/JavaScript">
		<!--
		function initTab() {
			$('#daysTab a:last').tab('show');
		}
		//   -->
		</script>

	<%@ include file="footer.html"%>
