<%@ include file="header.jsp"  %>
<body>
<%@ include file="menu.jsp"%>

<div class="well well-small">
      <h1><spring:message code="versionhistory" text="versionhistory"/></h1>
</div>

<div class="container">

	<h3>Version 2.8</h3>
	<ul>
		<li>added marketplace for user defined open space sessions</li>
		<li>added twitter integration on the session detail page</li>
		<li>added automatic reload for twitter wall</li>
	</ul>
	<h3>Version 2.7</h3>
	<ul>
		<li>added a new venue map</li>
		<li>Changed order of sessions in session overview</li>
	</ul>

	<h3>Version 2.6</h3>
	<ul>
		<li>Added a twitter wall to the app showing conference related tweets. Please use http://ec2-54-242-239-6.compute-1.amazonaws.com/thot </li>
	</ul>
	<h3>Version 2.5</h3>
	<ul>
		<li>Added voting for sessions on comment level</li>
		<li>Added list of currently ongoing sessions</li>
	</ul>
	<h3>Version 2.4</h3>
	<ul>
		<li>Added venue map</li>
	</ul>
	<h3>Version 2.3</h3>
	<ul>
		<li>Removed edit link for sessions</li>
		<li>Link the whole row to open the session details</li>
	</ul>

	<h3>Version 2.2</h3>
	<ul>
		<li>Added tabs for each day of the conference. Each tab only contains the sessions on that day.</li>
	</ul>

	<h3>Version 2.1</h3>
	<ul>
		<li>Added all session to the session overview</li>
		<li>Created a link on the session title to open a session detail page</li>
	</ul>

	<h3>Version 2.0 </h3>
	<ul>
		<li>Prepared almost empty version for XPdays</li>
		<li>Removed AgileCoachCamp specific stuff</li>
	</ul>
	<hr>
	<h3>Version 1.13 </h3>
	<ul>
		<li>Twitter handles are converted into links now</li>
	</ul>
	
	<h3>Version 1.12 </h3>
	<ul>
		<li>Prepared version for Agile Coach Camp</li>
	</ul>

	<h3>Version 1.11-* at Day 3 since 10:00</h3>
	<ul>
		<li>Editing open space sessions</li>
		<li>Lots of fixes</li>
		<li>...</li>
	</ul>
	
	<h3>Version 1.10 at Day 2 17:41</h3>
	<ul>
		<li>Navbar fixed</li>
		<li>Commenter name remembered after first comment</li>
	</ul>
	
	<h3>Version 1.9 at Day 2 16:45</h3>
	<ul>
		<li>Recent comment list - timeline</li>
		<li>Resized map image</li>
		<li>Relocated comment button on the schedule site</li>
		<li>Back button on the session details page</li>
		<li>Display  open space description</li>
		<li>Removed title get parameter</li>
		<li>Spanish and italien i18n</li>
	</ul>

	<h3>Version 1.8 at Day 2 12:45</h3>
	<ul>
		<li>new table view layout for the open space page</li>
		<li>new layout for the menu bar</li>
		<li>French i18n</li>
		<li>venue map</li>
		<li>fixed bug with the order of comments</li>
	</ul>
		<h3>Version 1.7 at Day 2 11:20</h3>
      <ul>
       <li>fixed encoding and timezone</li>
       <li>seperated comment input from comment list</li>
       <li>added important program points (lunch!)</li>
       <li>fixed navbar bug and removed modal layer</li>
       <li>added internationalization ability</li>
	  </ul>	
   <h3>Version 1.6 at Day 2 08:40</h3>
      <ul>
       <li>added the session data again</li>
       <li>change refresh interval to 20 secs</li>
	  </ul>
   <h3>Version 1.5 at Day 2 0:59</h3>
      <ul>
       <li>Added automatic reload for Market Place entries</li>
       <li>Removed Session data</li>
       <li>Removed Home Page</li>
       <li>added comments for OpenSpaces</li>
       <li>renamed "Open Spaces" to "Market Place"</li>
	  </ul>

   <h3>Version 1.4 at 17:00</h3>
      <ul>
       <li>changed order of the menu items</li>
       <li>added page to handle to during deployment</li>
	  </ul>
    <h3>Version 1.3 at 15:40</h3>
      <ul>
       <li>added all open spaces to the list</li>
       <li>updated value list for available slots on wednesday</li>
	  </ul>
    <h3>Version 1.2 at 15:10</h3>
      <ul>
       <li>additional value list for room names</li>
       <li>added value list for slots instead of start and end date</li>
	  </ul>
    <h3>Version 1.1 at 13:40</h3>
      <ul>
       <li>Different labels in OpenSpace form</li>
       <li>Options for choosing the day in OpenSpace form</li>
	  </ul>
 

  <h3>Version 1.0 at 12:40</h3>
      <ul>
       <li>Simplified menu bar for Open Space Sessions</li>
       <li>Make "Add Open Space" available from the list of Open Spaces</li>
	  </ul>
 
     <h3>Startup features</h3>
      <ul>
       <li>List of planned sessions</li>
       <li>Add additional Open Spaces</li>
       <li>List of additional Open Spaces</li>
      </ul>
	  	 
    </div> <!-- /container -->

<%@ include file="footer.html"  %>