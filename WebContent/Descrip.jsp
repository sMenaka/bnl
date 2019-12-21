<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.birdnestlanka.db.GetInfo"%>
<%@page import="org.birdnestlanka.beans.Info"%>
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
<link rel="stylesheet" href="css/panel.css">
</head>
<body>
	<%
						String val = request.getParameter("name");
						String desc="coming soon";
						String spName=null;
						String commName=null;
					%>
	<%try{
					GetBirdSpecies sp=new GetBirdSpecies(); 
					List<BirdSpecies> splist=sp.getSpeciesUseSPID(val);
					for (BirdSpecies sps:splist){
						spName=sps.getSpecies_Name();
						commName=sps.getCommon_Name();
					}
					
GetInfo info=new GetInfo();
List<Info> infoList=info.outInfo(val);
for(Info i:infoList){
	desc=i.getDescrip();
}
					}
	catch(Exception e){
		out.println("coming soon" );
	}
%>
	<div class="row">
		<div class="col-sm-10 col-xs-10"
			style="background-color: #ffffff; height: 150px;">
			<img src="image/head_homePage.png" width="100%" height="100%">
		</div>
		<div class="col-sm-2 col-xs-2"
			style="background-color: #ffffff; height: 150px;"><img src="image/logo.png" width="85%" height="105%"></div>
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
		<div class="col-sm-2"
			style="background-color:#014712; height: 800px;">
		      <form class="navbar-form" role="search" action="BirdList.jsp">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Seach Image" name="q" list="spList">
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
							<li><a href=<%="\"NewUpdates.jsp?name="+20+"\"" %>><font size="4px"
									color=" #ffffff "><b>Latest Contributions</b></font></a></li>
							<br>
							<li><a href="#about"><font size="4px" color=" #ffffff "><b>About</b></font></a></li>
						</ul>
					</td>
				</tr>
			</table>
		</div>
		<div class="col-sm-7"
			style="background-color: #014712; height: 800px;">
			<table>
				<col width="600">
				<tr><td bgcolor="#020202"><font color="#ffffff" size="3px"><i><%=spName %></i>&nbsp;<%=commName %></font></td></tr>
				<tr bgcolor="#5b0000">
					<td><font color="#ffffff"><%=desc %></td>
				</tr>
			</table>

		</div>
		<div class="col-sm-3"
			style="background-color: #014712; height: 800px;"></div>
	</div>

</body>
</html>