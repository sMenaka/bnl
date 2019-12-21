<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.birdnestlanka.db.GetBird"%>
<%@ page import="org.birdnestlanka.db.GetBirdSpecies"%>
<%@ page import="org.birdnestlanka.beans.BirdSpecies"%>
<%@ page import="org.birdnestlanka.beans.Bird"%>
<%@ page import="org.birdnestlanka.db.GetPhotographer"%>
<%@ page import="org.birdnestlanka.beans.Photographer"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bird Image</title>
<link rel="icon" type="image/png" href="image/title.png">
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
			style="background-color:#014712; height: 1300px;">
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
			<%try{
				String PhotoGrapher = null;
			String Email=null;
				String val = request.getParameter("name");
				List<String> strlist = new ArrayList<String>(Arrays.asList(val.split("-")));
				String Sp_ID=strlist.get(0);
				int item=Integer.parseInt(strlist.get(1));
				
			%>
			<%
			Bird blist=null;
				GetBird getbird = new GetBird();
				List<Bird> list = getbird.getBirdSpesices(Sp_ID);
				if(item>-1 && list.size()-1>=item){
				 blist=list.get(item); }
				else{
					blist=list.get(0);
					item=0;
				}
					String url = blist.getImgUrl();
					System.out.println(url);
			%>
			<%
				GetPhotographer photo = new GetPhotographer();
					List<Photographer> plist = photo.getPhotographerList(Integer.toString(blist.getPhotographerId()));

					for (Photographer pg : plist) {

						PhotoGrapher = pg.getPhotographer_Name();
						Email=pg.getPhotographer_Email();
					}
			%>
		
				<div class="col-md-7"
			style="background-color: #014712; height: 1300px;">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel panel-heading">
						<center>Bird Image</center>
					</div>
					<div class="panel-body">

						<label>Common Name-</label>&nbsp;<%=blist.getCommon_Name()%>&nbsp;
						<label>Photographer-</label> &nbsp;<%=PhotoGrapher%>
						<table>
						<col width="100">
						<col width="650">
						<tr><td><a href=<%="\"ImageView.jsp?name=" + Sp_ID +"-"+Integer.toString(item-1)+ "\""%>> << previous </a></td>
						<td align="right"><a href=<%="\"ImageView.jsp?name=" + Sp_ID +"-"+Integer.toString(item+1)+ "\""%>>Next >></a></td></tr>
						</table>
						<center>

							<img src="<%=url%>" width="70%" height="70%" />
						</center>
						<br>
						<center>
							<table  BORDER="2" BORDERCOLOR="#ffffff">
							<col width="150">
  							<col width="600">
								<tr>
									<td bgcolor="#522f2f"><font color="#ffffff">&nbsp;Common Name</font></td>
									<td bgcolor=" #e1e1e1">&nbsp;<%=blist.getCommon_Name() %></td>
								</tr>
								<tr>
									<td bgcolor="#522f2f"><font color="#ffffff">&nbsp;Species Name</font></td>
									<td bgcolor=" #e1e1e1">&nbsp;<%=blist.getSpecies() %></td>
								</tr>
								<tr>
									<td bgcolor="#522f2f"><font color="#ffffff">&nbsp;Other Names</font></td>
									<td bgcolor=" #e1e1e1">&nbsp;<%=blist.getOther_Name() %></td>
								</tr>
								<tr>
									<td bgcolor="#522f2f"><font color="#ffffff">&nbsp;Bird Group</font></td>
									<td bgcolor=" #e1e1e1">&nbsp;<%=blist.getGroup() %></td>
								</tr>
								<tr>
									<td bgcolor="#522f2f"><font color="#ffffff">&nbsp;Bird Family</font></td>
									<td bgcolor=" #e1e1e1">&nbsp;<%=blist.getFamily() %></td>								</tr>
								<tr>
									<td bgcolor="#522f2f"><font color="#ffffff">&nbsp;Remarks</font></td>
									<td bgcolor=" #e1e1e1">&nbsp;<%=blist.getRemarks() %></td>
								</tr>

							</table >
							</center>
							<center>
							<table BORDER="2" BORDERCOLOR="#ffffff">
							<col width="150">
  							<col width="600">
  							<tr>
  							<td bgcolor="#9b3838">
  							<font color="#ffffff">&nbsp;Photographer</font>
  							</td>
  							<td bgcolor=" #e1e1e1"><%=PhotoGrapher %></td>
  							</tr>
  							<tr>
  							<td bgcolor="#9b3838">
  							<font color="#ffffff">&nbsp;Email</font>
  							</td>
  							<td bgcolor=" #e1e1e1"><%=Email %></td>
  							</tr>
  							<tr>
  							<td bgcolor="#9b3838">
  							<font color="#ffffff">&nbsp;Date</font>
  							</td>
  							<td bgcolor=" #e1e1e1">&nbsp;<%=blist.getDate()%></td>
  							</tr>
  							<tr>
  							<td bgcolor="#9b3838">
  							<font color="#ffffff">&nbsp;Location</font>
  							</td>
  							<td bgcolor=" #e1e1e1">&nbsp;<%=blist.getLocation() %></td>
  							</tr>
  							<tr>
  							<td bgcolor="#9b3838">
  							<font color="#ffffff">&nbsp;Equipments</font>
  							</td>
  							<td bgcolor=" #e1e1e1">&nbsp;<%=blist.getEquip() %></td>
  							</tr>
  							
							</table>
						<label>Description Of Species</label> <a href="#" >Click Here</a>  
						
						
						</center>
					
			
							
							</div>
						
					

					<%}
			catch(Exception e){
				out.print("No Images");
			}%>
					</div>
				</div>
			</div>
			<div class="col-md-3"
			style="background-color:#014712; height: 1300px;">
	</div>
</div>
</body>
</html>