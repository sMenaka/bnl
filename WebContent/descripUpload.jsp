<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.birdnestlanka.db.GetBirdSpecies"%>
<%@ page import="org.birdnestlanka.beans.BirdSpecies"%>
<%@ page import="org.birdnestlanka.db.GetPhotographer"%>
<%@ page import="org.birdnestlanka.beans.Photographer"%>

<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="image/title.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Image Upload</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/panel.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-10 col-xs-10"
			style="background-color: #ffffff; height: 150px;">
			<img src="image/head_homePage.png" width="100%" height="100%">
		</div>
		<div class="col-sm-2 col-xs-2"
			style="background-color: #ffffff; height: 150px;"><img src="image/logo.png" width="85%" height="105%"></div>
	</div>
	
	
	<div class="row">
		<div class="col-sm-3"
			style="background-color: #014712; height: 500px;">
 <form class="navbar-form" role="search">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Seach Image" name="q">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit">Search</button>
            </div>
        </div>
        </form>
		<table>
			<tr>
			<td bgcolor="#014712">
			<ul>
				<li><a class="active" href="index.jsp"><font size="4px" color=" #ffffff "><b>Home</b></font></a></li>
				<br>
				<li><a href="photgraphers.jsp"> <font size="4px" color=" #ffffff "><b>Photographers</b> &nbsp;</font> </a></li>
				<br>
				<li><a href="ViewGroup.jsp"><font size="4px" color=" #ffffff "><b>Bird Images</b></font></a></li>
				<br>
				<li><a href=<%="\"NewUpdates.jsp?name="+20+"\"" %>><font size="4px" color=" #ffffff "><b>Latest Contributions</b></font></a></li>
				<br>
				<li><a href="#about"><font size="4px" color=" #ffffff "><b>About</b></font></a></li>
			</ul> </td></tr></table>
		</div>
		<div class="col-sm-6"
			style="background-color: #014712; height: 500px;">
			<datalist id="spList"> <%
 	GetBirdSpecies group = new GetBirdSpecies();
 	List<BirdSpecies> spList = group.getSpecies();
 	for (BirdSpecies sp : spList) {
 %>

			<option value="<%=sp.getCommon_Name() %>">

				<%
					}
				%>
			
			</datalist>
	
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel panel-heading">
						<center>Upload Bird Description</center>
					</div>
					<div class="panel-body">
						<center>
							<form method="post" action="uploadDescrip"
								enctype="multipart/form-data">
								<table BORDER="3" BORDERCOLOR="#7e7e7e">
									<tr>
										<td><label>Bird Species</label></td>
										<td ><input type="text" name="species"
											size="50" list="spList"></td>
									</tr>
									<br>
									
									<tr>
										<td><label>Description</label></td>
										<td ><textarea placeholder="Type Here Description"
												name="remarks" rows="6" cols="49"></textarea></td>
									</tr>
									<tr>
										<td><label> Select Sound file to upload:</label></td>
										<td><input type="file" name="uploadFile" /></td>
									</tr>
									
								</table>
								<input type="submit" value="Upload" />
					</div>
				</div>
			</div>
			</form>
			</center>
		</div>
		<div class="col-sm-3"
			style="background-color: #014712; height: 500px;"></div>
	</div>
	<div class="row">
		<div class="col-sm-12"
			style="background-color: #014712; height: 200px;"></div>
	</div>
</body>
</html>