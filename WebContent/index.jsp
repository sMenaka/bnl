<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.birdnestlanka.db.GetBird"%>
<%@ page import="org.birdnestlanka.beans.Bird"%>
<%@ page import="org.birdnestlanka.db.GetBirdSpecies"%>
<%@ page import="org.birdnestlanka.beans.BirdSpecies"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="bird nest lanka " content="bird species,bir group" />
<head>
<link rel="icon" type="image/png" href="image/title.png">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/simple-sidebar.css" rel="stylesheet">

<title>Birdnestlanka.org</title>
<link rel="stylesheet" href="butttons/one.css" type="text/css">
<link rel="stylesheet" href="css/buttons.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link href="css/New.css" rel="stylesheet">


</head>
<%
	GetBird bird = new GetBird();
	List<Bird> ImageList = bird.getBird();
	Bird image = ImageList.get(ImageList.size() - 1);
%>

<body class="my">
	<div class="row">
		<div class="col-md-10 col-sm-10"
			style="background-color: #ffffff; height: 150px;">
			<img src="image/head_homePage.png" width="100%" height="100%">
		</div>
		<div class="col-md-2 col-sm-2"
			style="background-color: #ffffff; height: 150px;"><img src="image/logo 3.png" ></div>
			
	</div>

<datalist id="spList"> <%
 	GetBirdSpecies group = new GetBirdSpecies();
 	List<BirdSpecies> spList = group.getSpecies();
 	for (BirdSpecies sp : spList) {
 %>

			<option value="<%=sp.getCommon_Name()%>">
			<option value="<%=sp.getCommon_Name2()%>">
				<%
					}
				%>
			
			</datalist>
	<div class="row">
<div class="my-menu col-lg-2 col-md-12 col-sm-12">
    <ul class="my-menu nav nav-pills nav-stacked">
    <li>
    	<form class="navbar-form" role="search" action="BirdList.jsp">
        <div class="input-group">
      <input type="text" class="form-control"name="q" list="spList" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Go!</button></form>
      </span>
    </div><!-- /input-group -->
        </li>
        <br>
  <li role="presentation" class="active"><a href="index.jsp">Birdnestlanka</a></li>
  <li role="presentation"><a href="ViewGroup.jsp">Bird images</a></li>
  <li role="presentation"><a href="photgraphers.jsp">Photographers</a></li>
  <li role="presentation"><a href=<%="\"NewUpdates.jsp?name="+20+"\"" %>>Latest contributions</a></li>
</ul>
      </div>
		<div class="col-md-6 col-sm-12"
			style="background-color: #014712; height: 550px;">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><b><font color="#ffffff">Image of the day</font></b> </label>&nbsp;&nbsp;
			<b><font color="#ffffff"><%=image.getCommon_Name()%></font></b>
			
			<img src="<%=image.getImgUrl()%>" class="img-rounded" width="100%" height="auto%" />
			
			<br>
			
		</div>
		
		<div class="col-md-4 col-sm-12"
			style="background-color: #014712; height: 550px;">
			<br><table>
				<col width="600">
		<tr>
		<td class="mtd"><font color=#f8ff8f size=4px>Sri Lanka is gifted with over 500 birds species and more than 30 species of them are endemic.<br><br>
This site tries to share the knowledge about endemic, resident, migrant and vagrant species,
Including their plumage description, sounds and etc.<br><br>
 Photographers are welcomed to contribute their images to this site.<br><br>

Contact the editors</font>
<font color=#d1d2f3 size=4px>
<br>premasiri.mapalagama@yahoo.com<br>
dissanaw@gmail.com<br>
wijegunasinghe@gmail.com</font>
				</td>
		</tr>

			</table>
		</div>
	</div>


	<div class="row">
		<div class="col-sm-1 col-xs-12"
			style="background-color: #555454; height: 175px;"></div>
		<div class="col-sm-2 col-xs-12"
			style="background-color: #555454; height: 175px;">
<br>
			<center>
				<a href="photgraphers.jsp"><img src="buttons/photo.png"
					width="80%" height="80%"></a>
			</center>
		</div>
		<div class="col-sm-2 col-xs-12"
			style="background-color: #555454; height: 175px;">
<br>
			<center>
				<a href="ViewGroup.jsp"><img src="buttons/group.png"
					width="100%" height="100%">
			</center>
		</div>
		<div class="col-sm-2 col-xs-12"
			style="background-color: #555454; height: 175px;">
<br>
			<center>
				<a href="NewUpdates.jsp"><img src="buttons/let.png"
					width="80%" height="80%"></a>
			</center>
		</div>
		<div class="col-sm-2 col-xs-12"
			style="background-color: #555454; height:175px;">
<br>
			<center>
				<a href="groupForDes.jsp"><img src="buttons/des.png" width="90%"
					height="90%"></a>
			</center>
		</div>


		<div class="col-sm-2 col-xs-12"
			style="background-color: #555454; height: 175px;">
<br>
			<center>
				<a href="GroupSou.jsp"><img src="buttons/soud.png" width="80%"
					height="70%"></a>
			</center>
		</div>
		<div class="col-sm-1 "
			style="background-color: #555454; height: 175px;"></div>
	</div>

	<div class="row">

		<div class="col-sm-12 col-xs-12"
			style="background-color: #FFFFFF; height: 50px;">
			<table>
			
				<tr>
					<td align="justify">All the images in this database are copy righted images
						should not be printed, reproduced, published by any other mean,
						without the permission of editors /photographers.</td>
				</tr>
			</table>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>