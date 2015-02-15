<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="twitter4j.Twitter"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title><spring:message code="header.title" text="Hackerspace - Building a conference app - JavaLand 2015"/></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 
	<link rel="stylesheet" href="<%= request.getContextPath() %>/webjars/bootstrap/2.3.2/css/bootstrap.min.css">
	<link href="<%= request.getContextPath() %>/assets/css/bootstrap.css" rel="stylesheet">
 -->	
	<link href="<%= request.getContextPath() %>/assets/css/thot.css" rel="stylesheet">
	<link href="<%= request.getContextPath() %>/assets/css/bootstrap-responsive.css" rel="stylesheet">
	
	<!-- Favicon -->
	<link rel="icon" type="image/png" href="<%= request.getContextPath() %>/assets/img/favicon.png"/>
	
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-53994758-1', 'auto');
	  ga('send', 'pageview');
	
	</script>

</head>
