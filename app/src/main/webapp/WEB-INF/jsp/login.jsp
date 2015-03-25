<%@ include file="header.jsp"%>
<div class="well well-small">
	
<h1>Login page</h1>
</div>
<div class="panel-body">



<form id="tw_signin" action="<c:url value="/signin/twitter"/>" method="POST">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">
   	 <img src="<%=request.getContextPath()%>/img/sign-in-with-twitter-gray.png" />
    </button>
</form>

</div>

<%@ include file="footer.html"%>