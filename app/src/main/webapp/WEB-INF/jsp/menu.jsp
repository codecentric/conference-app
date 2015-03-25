<spring:eval expression="@environment.getProperty('feature.toggle.current.sessions')" var="featureToggleCurrentSessions" />
<spring:eval expression="@environment.getProperty('feature.toggle.static.sessions')" var="featureToggleStaticSessions" />
<spring:eval expression="@environment.getProperty('feature.toggle.twitter.wall')" var="featureToggleTwitterWall" />
<spring:eval expression="@environment.getProperty('feature.toggle.search.sessions')" var="featureToggleSearchSessions" />
<spring:eval expression="@environment.getProperty('feature.toggle.venue.map')" var="featureToggleVenueMap" />
<spring:eval expression="@environment.getProperty('feature.toggle.feedback')" var="featureToggleFeedback" />
<spring:eval expression="@environment.getProperty('feature.toggle.news')" var="featureToggleNews" />
<spring:eval expression="@environment.getProperty('feature.toggle.changelog')" var="featureToggleChangelog" />
<spring:eval expression="@environment.getProperty('feature.toggle.app.structure')" var="featureToggleAppStructure" />

    <div class="container-fluid">

      <!-- Static navbar -->

        <nav class="navbar navbar-default">

        <div>
          <div class="navbar-header">
            <!-- aria-expanded="false" aria-controls="navbar" -->
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" >
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="home">JavaLand 2015</a>
          </div>

          <div class="collapse navbar-collapse" id="navbar" >
            <ul class="nav navbar-nav">
              <c:if test="${featureToggleCurrentSessions}">
              	<li><a href="currentSessions"><spring:message code="current.sessions.title" text="Current Sessions"/></a></li>
              </c:if>
              <c:if test="${featureToggleStaticSessions}">
			  	<li><a href="staticSessions"><spring:message code="sessions" text="Sessions"/></a></li>
			  </c:if>
			  <c:if test="${featureToggleTwitterWall}">
				<li><a href="twitterWall"><spring:message code="twitter" text="Twitter"/></a></li>
			  </c:if>
			  <c:if test="${featureToggleSearchSessions}">
			  	<li><a href="searchSessions"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></li>
			  </c:if>
			  <c:if test="${featureToggleVenueMap}">
			  	<li><a href="venueMap"><spring:message code="map" text="Venue Map"/></a></li>
			  </c:if>
			  <c:if test="${featureToggleFeedback}">
			  	<li><a href="feedback"><spring:message code="feedback" text="User Feedback"/></a></li>
			  </c:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <c:if test="${featureToggleChangelog}">
                <li><a href="changelog"><spring:message code="versionhistory" text="Changelog"/></a></li>
              </c:if>
              <c:if test="${featureToggleAppStructure}">
                <li><a href="appStructure"><span class="glyphicon glyphicon-blackboard" aria-hidden="true"></span></a></li>
              </c:if>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

    </div> <!-- /container -->