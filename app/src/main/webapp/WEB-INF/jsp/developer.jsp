<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">Developer</h3>
	  </div>
	  <div class="panel-body">
			<div class="row-fluid">
			<div class="tabbable">
				<div class="tab-content">
					<table>
					<c:forEach items="${developerList}" var="developer">
					    <span class="glyphicon glyphicon-fire"></span>
					    <blockquote>
						    <p>${developer.fullname}</p>
						    <small>Github: ${developer.githubusername}</small>
					    </blockquote>
					</c:forEach>
					</table>
				</div>
			</div>
		</div>
	  </div>
	</div>

</div>

<%@ include file="footer.html"%>
