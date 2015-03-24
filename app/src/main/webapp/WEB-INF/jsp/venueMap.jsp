<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
	<%@ include file="menu.jsp"%>

    <%@ include file="news.jsp"%>

	<div class="container-fluid">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<spring:message code="map" text="Map" />
				</h3>
			</div>
			<div class="panel-body">

				<div class="row">
					<div class="span10">
						<div class="content-heading">
							<img
								src="<%=request.getContextPath()%>/img/ausstellerkatalog.jpg" />
						</div>
					</div>
				</div>

				<br/>

				<div class="row">
					<div class="col-md-4">
						<ul>
							<li>AppDynamics GmbH (404)</li>
							<li>BASIS Europe Distribution GmbH (302)</li>
							<li>BSI Business Systems Integration AG (304)</li>
							<li>Canoo Engineering AG (206)</li>
							<li>codecentric AG (502)</li>
							<li>Codetrails GmbH (210)</li>
						</ul>
					</div>
					<div class="col-md-4">
						<ul>
							<li>ETECTURE GmbH (314)</li>
							<li>IBM Emerging Internet Technologies Group (602)</li>
							<li>InterFace AG (208)</li>
							<li>JetBrains (212)</li>
							<li>JFrog (402)</li>
							<li>msg systems ag (508)</li>
						</ul>
					</div>
					<div class="col-md-4">
						<ul>
							<li>OPITZ CONSULTING Deutschland GmbH (204)</li>
							<li>Oracle Deutschland B.V. &amp; Co.KG (202)</li>
							<li>O'Reilly Verlag GmbH &amp; Co.KG (308)</li>
							<li>Red Hat Inc. (108)</li>
							<li>REWE Digital GmbH (406)</li>
							<li>Vaadin Ltd. (510)</li>
						</ul>
					</div>
				</div>

			</div>
		</div>

	</div>

	<%@ include file="footer.html"%>