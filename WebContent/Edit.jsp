<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.birdnestlanka.db.GetBirdSpecies"%>
<%@ page import="org.birdnestlanka.beans.BirdSpecies"%>
<%@ page import="org.birdnestlanka.db.GetBird"%>
<%@ page import="org.birdnestlanka.beans.Bird"%>
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
	<!--java codes start------------------------------------------------------------------------------->

	<datalist id="spList"> <%
 	GetBirdSpecies group = new GetBirdSpecies();
 	List<BirdSpecies> spList = group.getSpecies();
 	for (BirdSpecies sp : spList) {
 %>

	<option value="<%=sp.getCommon_Name()%>">

		<%
			}
		%>
	
	</datalist>
	<datalist id="pgList"> <%
 	GetPhotographer photo = new GetPhotographer();
 	List<Photographer> photoGList = photo.getPhotographerList();
 	for (Photographer pgl : photoGList) {
 %>
	<option value="<%=pgl.getPhotographer_Name()%>">
		<%
			}
		%>
	
	</datalist>
	<%
		String pGName = null;
		String name = request.getParameter("val");
		GetBird getBird = new GetBird();
		List<Bird> birdList = getBird.getBird(name);
		Bird bird = new Bird();
		bird = birdList.get(0);
	%>
	<%
		GetPhotographer photoG = new GetPhotographer();
		List<Photographer> photoList = photoG.getPhotographerList(Integer.toString(bird.getPhotographerId()));
		pGName = photoList.get(0).getPhotographer_Name();
		String [] date=bird.getDate().split("\\-");
		session.setAttribute("BirdID",bird.getId());
		session.setAttribute("Image", bird.getImgUrl());
	%>
	


	<!--java codes end ------------------------------------------------------------------------------->
	<div class="row">
		<div class="col-sm-10 col-xs-10"
			style="background-color: #ffffff; height: 150px;">
			<img src="image/head_homePage.png" width="100%" height="100%">
		</div>
		<div class="col-sm-2 col-xs-2"
			style="background-color: #ffffff; height: 150px;">
			<img src="image/logo.png" width="85%" height="105%">
		</div>
	</div>




	<div class="row">
		<div class="col-sm-2"
			style="background-color: #014712; height: 1100px;">
			<center>
				<form class="navbar-form" role="search" action="BirdList.jsp">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search Image"
							name="q" list="spList">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">>></button>
						</div>
					</div>
				</form>
				<table>
					<tr>
						<td bgcolor="#014712">
							<ul>
								<li><a class="active" href="index.jsp"><font size="4px"
										color=" #ffffff "><b>Home</b></font></a></li>
								<br>
								<li><a href="photgraphers.jsp"> <font size="4px"
										color=" #ffffff "><b>Photographers</b> &nbsp;</font>
								</a></li>
								<br>
								<li><a href="ViewGroup.jsp"><font size="4px"
										color=" #ffffff "><b>Bird Images</b></font></a></li>
								<br>
								<li><a href=<%="\"NewUpdates.jsp?name=" + 20 + "\""%>><font
										size="4px" color=" #ffffff "><b>Latest
												Contributions</b></font></a></li>
								<br>
								<li><a href="#about"><font size="4px" color=" #ffffff "><b>About</b></font></a></li>
							</ul>
						</td>
					</tr>
				</table>
		</div>
		<div class="col-sm-7"
			style="background-color: #014712; height: 1100px;">




			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel panel-heading">
						<center>Edit Content</center>
					</div>
					<div class="panel-body">
						<center>
							<img src="<%=bird.getImgUrl()%>" width="50%" height="50%" />
							<form method="post" action="update">
								<table BORDER="3" BORDERCOLOR="#7e7e7e">
									<tr>
										<td><label>Bird Species</label></td>
										<td colspan="3"><input type="text" name="species"
											size="60" value="<%=bird.getCommon_Name()%>" list="spList"
											value="" /></td>
									</tr>
									<br>
									<tr>
										<td><label>Other Names</label></td>
										<td colspan="3"><textarea name="other" rows="6" cols="49"
												><%=bird.getOther_Name()%></textarea></td>
									</tr>
									<tr>
										<td><label>Remarks</label></td>
										<td colspan="3"><textarea placeholder="Type Here Remarks"
												name="remarks" rows="6"
												cols="49"><%=bird.getRemarks()%></textarea></td>
									</tr>
									<br>
									<tr>
										<td><label>Location</label></td>
										<td colspan="3"><input type="text" name="location"
											value="<%=bird.getLocation() %>" size="60"></td>
									</tr>
									<tr>
										<td><label>Used Equipments</label></td>
										<td colspan="3"><input type="text" name="equip"
											value="<%=bird.getEquip()%>" size="60"></td>
									</tr>
									<tr>
										<td><label>Photographer</label></td>
										<td colspan="3"><input type="text" name="photographer"
											size="60" value="<%=pGName%>" list="pgList"></td>
									</tr>
									<tr>
										<td><label>Date</label></td>
										<td colspan="3"><input type="text" name="Year" size="4"
											value="<%=date[0] %>" placeholder="Year"> <input
											type="text" name="month" size="2" value="<%=date[1] %>" placeholder="Month">
											<input type="text" name="date" size="2" value="<%=date[2] %>" placeholder="Date"></td>
									</tr>
									<tr>
									</form>
									<td><input type="submit" class="btn btn-info" value="Update" /></td>
									
									<td align="right">
									<form method="post" action="delete">
									<input type="hidden" name="ID" value="<%=bird.getId()%>">
									<input type="hidden" name="comn"
											 value="<%=bird.getCommon_Name()%>"  />
									<input type="submit" class="btn btn-danger" value="Delete"></button>
									</form>
									</td>
									</tr>
									
									</center>
								</table>
								<br>
								
					</div>
				</div>
			</div>

		</div>
		<div class="col-sm-3"
			style="background-color: #014712; height: 1100px;"></div>
	</div>
	<div class="row">
		<div class="col-sm-12"
			style="background-color: #014712; height: 200px;"></div>
	</div>
</body>
</html>