<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title"><spring:message code="twitter" text="Twitter Wall"/></h3>
	  </div>
	  <div class="panel-body">
		
		<div class="row-fluid">
			<div class="tabbable">
				<ul class="nav nav-tabs" id="tagTabs">
					<li class="active"><a href="#hackerspace-tag" data-toggle="tab">#hackerspace</a></li>
					<li><a href="#javaland-tag" data-toggle="tab">#javaland</a></li>
				</ul>
			</div>
			<div class="tab-content">
				<div class="tab-pane" id="javaland-tag">
					<a class="twitter-timeline" href="https://twitter.com/hashtag/javaland" data-widget-id="274445737469820929">#javaland Tweets</a>
					<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
				</div>
				<div class="tab-pane" id="hackerspace-tag">
					<a class="twitter-timeline" href="https://twitter.com/hashtag/hackerspace" data-widget-id="274512147617300480">#hackerspace Tweets</a>
					<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
				</div>
			</div>
		</div>
	  </div>
	</div>

</div>

<%@ include file="footer.html"%>
