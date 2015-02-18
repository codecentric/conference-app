<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title"><spring:message code="error" text="Error"/></h3>
	  </div>
	  <div class="panel-body">
		<spring:message code="404.pagenotfound" text="Page not found"/>
	  </div>
	</div>

</div>

<%@ include file="footer.html"  %>
