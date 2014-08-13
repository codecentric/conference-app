<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="twitter4j.Twitter"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Open Space Software Development</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="<%= request.getContextPath() %>/assets/css/bootstrap.css" rel="stylesheet">

<!-- Favicon -->
<link rel="icon" type="image/png" href="<%= request.getContextPath() %>/assets/img/favicon.png"/>
<link href="<%= request.getContextPath() %>/assets/css/thot.css" rel="stylesheet">
<link href="<%= request.getContextPath() %>/assets/css/bootstrap-responsive.css" rel="stylesheet">
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-34741009-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</head>


