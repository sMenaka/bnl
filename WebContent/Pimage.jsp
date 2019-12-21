<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.birdnestlanka.db.GetPhotographer"%>
<%@ page import="org.birdnestlanka.beans.Photographer"%>
<%@ page import="org.birdnestlanka.db.GetBirdSpecies"%>
<%@ page import="org.birdnestlanka.beans.BirdSpecies"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="image/title.png">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Photographers</title>
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
		<div class="col-sm-2"
			style="background-color: #014712; height: 800px;">
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
		
		<div class="col-sm-8"
			style="background-color: #014712; height: 800px;">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel panel-heading">
						<center>Photographers</center>
					</div>
					<div class="panel-body">
						<center>
						<%
								String val = request.getParameter("name");
									GetPhotographer photographer = new GetPhotographer();
									List<Photographer> PGList = photographer.getPhotographerList(val);
									for (Photographer pg : PGList) {
								%>
							<table >
								<thead>
						
								<col width="600">
									<tr>
									<th bgcolor="#000000"><font color="#ffffff"><center><%=pg.getPhotographer_Name()%></center></font></th>
										
										
									</tr>
								</thead>
								
								<tbody>
									<tr>
									<td style="height: 100px;"><center>
												<a href=<%="\"Pimage.jsp?name=" +pg.getPhotographer_ID() +"\""%>><img src="<%=pg.getImg_URL()%>"class="img-rounded"></a>
											</center></td>
										
										
											
									</tr>
									<%
										}
									%>

								</tbody>
							</table>
						</center>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-2"
			style="background-color: #014712; height: 800px;"></div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="table/js/index.js"></script>
</body>
</html>