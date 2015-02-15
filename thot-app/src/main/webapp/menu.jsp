    <div class="container-fluid">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="home">JavaLand</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="currentSessions"><spring:message code="current.sessions.title" text="Current Sessions"/></a></li>		 
			  <li><a href="staticSessions"><spring:message code="sessions" text="Sessions"/></a></li>
			  <li><a href="twitterWall.jsp"><spring:message code="twitter" text="Twitter"/></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="searchSessions"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></li>
						<li><a href="map.jsp"><spring:message code="map" text="Venue Map"/></a></li>
						<li><a href="feedback"><spring:message code="feedback" text="User Feedback"/></a></li>
						<li><a href="features.jsp"><spring:message code="versionhistory" text="Changelog"/></a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>