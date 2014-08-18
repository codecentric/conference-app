	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> 
				<%-- <a class="brand" href="<%= request.getContextPath() %>">ALE 2012</a> --%>
				<div class="nav">
					<ul class="nav">
						<li><a href="staticSessions"><spring:message code="sessions" text="sessions"/></a></li>
						<li><a href="twitterWall.jsp"><spring:message code="twitter" text="twitter"/></a>	
					<!-- 
						<li><a href="<%= request.getContextPath() %>/allSessions">
							<spring:message code="marketplace" text="marketplace"/></a></li>
						-->		 
					</ul>
				</div>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="<%= request.getContextPath() %>/allSessions">
						<spring:message code="marketplace" text="marketplace"/></a></li>
						<li><a href="map.jsp"><spring:message code="map" text="map"/></a>	
						<li><a href="features.jsp"><spring:message code="versionhistory" text="versionhistory"/></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

