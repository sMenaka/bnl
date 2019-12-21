<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="image/title.png">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Result</title>

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
		<div class="col-sm-4"
			style="background-color: #555454; height: 300px;">
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
							<li><a href=<%="\"NewUpdates.jsp?name="+20+"\"" %>><font size="4px"
									color=" #ffffff "><b>Latest Contributions</b></font></a></li>
							<br>
							<li><a href="#about"><font size="4px" color=" #ffffff "><b>About</b></font></a></li>
						</ul>
					</td>
				</tr>
			</table>
		</div>
		<div class="col-sm-5"
			style="background-color: #014712; height: 300px;">
			<br>
			<div class="alert alert-success">
				<strong>Upload Result</strong>
				<center>
					<h2>${message}</h2>
				</center>
			</div>
		</div>
		<div class="col-sm-3"
			style="background-color: #555454; height: 300px;"></div>
	</div>
</body>
</html>