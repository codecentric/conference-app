<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="well well-small">
		<h1>
			<spring:message code="versionhistory" text="versionhistory" />
		</h1>
	</div>

	<h3>Wednesday - 20.08.2014</h3>

	<h4>Version 1</h4>
	
	<ul>
		<li>Feedback function for the app</li>
		<li>Commenting and rating of session</li>
		<li>Adding Links for additional resources to session</li>
		<li>I18N language support</li>
	</ul>

	<h3>
		<spring:message code="features.startupfeatures" text="Startup features" />
	</h3>
	
	<ul>
		<li><spring:message code="features.plannedsessions"
				text="List of planned sessions" /></li>
		<li><spring:message code="features.addopenspaces"
				text="Add additional Open Spaces" /></li>
		<li><spring:message code="features.listadditionalopenspaces"
				text="List of additional Open Spaces" /></li>
		<li><spring:message code="features.twitterintegration"
				text="Twitter integration" /></li>
	</ul>

	<%@ include file="footer.html"%>

</div>
