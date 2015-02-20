<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">Links for session: <small>${sessionTitle}</small></h3>
	  </div>
	  <div class="panel-body">
	
		<div class="row-fluid">
		<!-- commit form -->
		<form:form commandName="linkFormData" method="POST" class="form-horizontal">
		  <div class="form-group">
		    <label for="author" class="col-sm-2 control-label">URL</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="url" name="url">
		      <form:errors class="form-error" path="url" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="text" class="col-sm-2 control-label">Comment</label>
		    <div class="col-sm-5">
		      <textarea class="form-control" rows="3" id="comment" name="comment"></textarea>
		      <form:errors class="form-error" path="comment" />
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default" id="addLink">Add link</button>
		    </div>
		  </div>
		</form:form>

	  </div>
	</div>
  </div>
</div>

<%@ include file="footer.html"%>
