<%@ include file="header.jsp"%>
<body>

<div class="container-fluid">

<%@ include file="menu.jsp"%>
	
	<div class="well well-small">
			<h3><spring:message code="twitter" text="twitter"/></h3>
	</div>
	<br style="clear: both;"/>

	<div class="row">
		<div class="tabbable">
			<ul class="nav nav-tabs" id="tagTabs">
				<li class="active"><a href="#ale14-tag" data-toggle="tab">#ale14</a></li>
				<li><a href="#osswdev-tag" data-toggle="tab">#osswdev</a></li>
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
	
	<%@ include file="footer.html"%>

</div>
