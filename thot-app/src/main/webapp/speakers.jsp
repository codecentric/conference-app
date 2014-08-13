<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>


<div class="container-fluid">


	<!--/span-->
	<div class="well well-small">
	<h1>Speakers</h1>
	</div>
<!-- 	
	<div style="float: right;">
			<a class="btn btn-primary" href="<%= request.getContextPath() %>/editSession">Add OpenSpace</a>
	</div>
-->
	<br style="clear: both;"/>


	<div class="row-fluid">
		<div >
			<a href="speaker">
				<input type="button" id="addSpeaker" value="Add speaker" class="btn btn-primary" />
			</a>
		</div>
		<table class="table table-striped" style="width:auto">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<c:if test="${useMail}">
						<th>E-Mail</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${speakers}" var="speaker">
				<c:url value="speaker" var="url" scope="page">
                    <c:param name="id" value="${speaker.id}" />
                </c:url>
				<tr class="sessions" id="speaker${speaker.foreName}${speaker.lastName}" data-link="${url}">
					<td>${speaker.foreName}</td>
					<td>${speaker.lastName}</td>
					<c:if test="${useMail}">
						<td><a href="mailto:${speaker.mail}">${speaker.mail}</a></td>
					</c:if>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="footer.html"%>
</div>


