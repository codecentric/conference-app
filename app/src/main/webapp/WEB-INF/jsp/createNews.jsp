<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="de.codecentric.util.TwitterLinkCreator"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title"><spring:message code="news" text="Recent comments"/></h3>
	  </div>
	  <div class="panel-body">

		<div class="row-fluid">
			<form:form commandName="newsFormData" method="POST" class="form-horizontal">
			  <div class="form-group">
			    <label for="text" class="col-sm-2 control-label">News</label>
			    <div class="col-sm-5">
			      <textarea class="form-control" rows="3" id="text" name="text"></textarea>
			      <form:errors class="form-error" path="text" />
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default" id="addNews">Publish News</button>
			    </div>
			  </div>
			</form:form>
		</div>

		<hr/>
	  </div>
	</div>
</div>

<%@ include file="footer.html"%>