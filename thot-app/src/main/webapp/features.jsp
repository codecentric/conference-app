<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="well well-small">
		<h1>
			<spring:message code="versionhistory" text="versionhistory" />
		</h1>
	</div>

	<h3>Friday - 22.08.2014</h3>

	<h4>Version 1.4</h4>
	
	<ul>
		<li>Added ALE Logo</li>
		<li>Fixed index html Bug</li>
	</ul>
	
	<h4>Version 1.3</h4>
	
	<ul>
		<li>Added Session Type to Tables</li>
		<li>Added upcoming sessions to current sessions</li>
		<li>Fixed Session Type bugs</li>
		<li>Added more acceptance tests</li>
	</ul>

	<h3>Thursday - 21.08.2014</h3>

	<h4>Version 1.2</h4>
	
	<ul>
		<li>Added author search</li>
		<li>Added current session page that displays all open space and static sessions</li>
		<li>Update DB schema: update session set type = 'openspace' where type is null;</li>
		<li>Fixed minor layouting bugs for mobil devices</li>
		<li>Put Twitter widgets on different tabs (mobil devices)</li>
	</ul>
	
	<h3>Wednesday - 20.08.2014</h3>

	<h4>Version 1.1</h4>
	
	<ul>
		<li>Commenting and rating of session</li>
		<li>Adding Links for additional resources to session (i.e. Slides, PDF files, ...)</li>
	</ul>

	<h4>Version 1</h4>
	
	<ul>
		<li>Feedback function for the app</li>
		<li>I18N language support (New: Romanian)</li>
		<li>Fixed Tab Bug, always show current day for Open Spaces</li>
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
