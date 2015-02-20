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
	    <h3 class="panel-title">WebApp Structure</h3>
	  </div>
	  <div class="panel-body">
	
		<script type="text/javascript" src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['orgchart']}]}"></script>
    	<div id="chart_div"></div>
    			
    		<script type="text/JavaScript">
      	      google.setOnLoadCallback(drawChart);
      	      function drawChart() {
      	        var data = new google.visualization.DataTable();
      	        data.addColumn('string', 'Name');
      	        data.addColumn('string', 'Manager');

      	        data.addRows([
      	          [{v:'home', f:'home<div style="color:green; font-style:italic">Startpage</div>'}, ''],
      	          [{v:'currentSessions', f:'currentSessions<div style="color:green; font-style:italic">Current Sessions</div>'}, 'home'],
      	          [{v:'staticSessions', f:'staticSessions<div style="color:green; font-style:italic">Static Sessions</div>'}, 'home'],
      	          [{v:'twitterWall', f:'twitterWall<div style="color:green; font-style:italic">Twitter Wall</div>'}, 'home'],
      	          [{v:'searchSessions', f:'searchSessions<div style="color:green; font-style:italic">Search Sessions</div>'}, 'home'],
      	          [{v:'map', f:'venueMap<div style="color:green; font-style:italic">Venue Map</div>'}, 'home'],
      	          [{v:'feedback', f:'feedback<div style="color:green; font-style:italic">Feedback</div>'}, 'home'],
      	          [{v:'features', f:'features<div style="color:green; font-style:italic">Features</div>'}, 'home'],
      	          [{v:'comments', f:'comments<div style="color:green; font-style:italic">Comments</div>'}, 'staticSessions'],
      	          [{v:'addLink', f:'addLink<div style="color:green; font-style:italic">Add Link</div>'}, 'staticSessions'],
      	        ]);

      	        var chart = new google.visualization.OrgChart(document.getElementById('chart_div'));
      	        chart.draw(data, {allowHtml:true});
      	      }
			</script>

	</div>
  </div>

</div>

<%@ include file="footer.html"%>