<nav class="navbar navbar-default">
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="brand"><img src="assets/img/JavaLand.png" height="25px"></a>
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> 
				<div class="nav">
					<ul class="nav">
						<li><a href="currentSessions"><spring:message code="current.sessions.title" text="Current Sessions"/></a></li>		 
						<li><a href="staticSessions"><spring:message code="sessions" text="Sessions"/></a></li>
						<li><a href="twitterWall.jsp"><spring:message code="twitter" text="Twitter"/></a></li>
					</ul>
				</div>
				<div class="nav-collapse">
					<ul class="nav">
					    <li><a href="searchSessions"><spring:message code="search" text="Author Search"/></a></li>
						<li><a href="map.jsp"><spring:message code="map" text="Venue Map"/></a></li>
						<li><a href="feedback"><spring:message code="feedback" text="User Feedback"/></a></li>
						<li><a href="features.jsp"><spring:message code="versionhistory" text="Changelog"/></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>