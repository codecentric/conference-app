	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="brand" href="index.html"> <img src="http://procognita.com/fileadmin/templates/images/content/event/ALE2014_logo.png" width="70px"></a>
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> 
				<%-- <a class="brand" href="<%= request.getContextPath() %>">ALE 2012</a> --%>
				<div class="nav">
					<ul class="nav">
						<li><a href="currentSessions"><spring:message code="current.sessions.title" text="Current Sessions"/></a></li>		 
						<li><a href="<%= request.getContextPath() %>/allSessions">	
						<spring:message code="marketplace" text="marketplace"/></a></li>
						<li><a href="staticSessions"><spring:message code="sessions" text="sessions"/></a></li>
						<li><a href="twitterWall.jsp"><spring:message code="twitter" text="twitter"/></a>	
					</ul>
				</div>
				<div class="nav-collapse">
					<ul class="nav">
					    <li><a href="searchSessions"><spring:message code="search" text="search"/></a></li>
						<li><a href="map.jsp"><spring:message code="map" text="map"/></a>
						<li><a href="<%= request.getContextPath() %>/feedback"><spring:message code="feedback" text="feedback"/></a>
						<li><a href="features.jsp"><spring:message code="versionhistory" text="versionhistory"/></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	

