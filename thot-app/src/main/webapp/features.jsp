<%@ include file="header.jsp"  %>
<body>
<%@ include file="menu.jsp"%>

<div class="well well-small">
      <h1><spring:message code="versionhistory" text="versionhistory"/></h1>
</div>

<div class="container">

	<h3><spring:message code="features.startupfeatures" text="Startup features"/></h3>
      <ul>
       <li><spring:message code="features.plannedsessions" text="List of planned sessions"/></li>
       <li><spring:message code="features.addopenspaces" text="Add additional Open Spaces"/></li>
       <li><spring:message code="features.listadditionalopenspaces" text="List of additional Open Spaces"/></li>
       <li><spring:message code="features.twitterintegration" text="Twitter integration"/></li>
      </ul>
	  	 
    </div> <!-- /container -->

<%@ include file="footer.html"  %>