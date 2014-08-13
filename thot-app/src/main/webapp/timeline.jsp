<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="org.ale.app.TwitterLinkCreator"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body  onload="JavaScript:timedRefresh(30000);">
<%@ include file="menu.jsp"%>


<div class="container-fluid">


	<!--/span-->
	<div class="well well-small">
	<h1><spring:message code="timeline" text="Recent comments"/></h1>
	</div>
	
	<br style="clear: both;"/>

	<div class="row-fluid">
		<div class="tabbable">
			<div class="tab-content">
				<table>
				<c:forEach items="${recentComments}" var="entry">
					<span style="font-style: bold; font-size: 1.2em;"><a href='comments?sessionId=${entry.sessionId}'>${entry.sessionTitle}</a></span>, <small>${entry.date}</small>
				    <blockquote>
					    <p>${entry.comment}</p>
					    <small>${entry.processedUser}</small>
				    </blockquote>
				</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.html"%>
