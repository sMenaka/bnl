package org.birdnestlanka.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.birdnestlanka.beans.Bird;
import org.birdnestlanka.beans.BirdFamily;
import org.birdnestlanka.beans.BirdGroup;
import org.birdnestlanka.beans.BirdSpecies;
import org.birdnestlanka.beans.Photographer;
import org.birdnestlanka.db.GetBirdFamily;
import org.birdnestlanka.db.GetBirdGroup;
import org.birdnestlanka.db.GetBirdSpecies;
import org.birdnestlanka.db.GetPhotographer;
import org.birdnestlanka.db.Update;

public class UpdateServlet extends HttpServlet {
	public UpdateServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse respons)
			throws ServletException, IOException {
		try {
			
			HttpSession sesForNum=request.getSession();
			String num=sesForNum.getAttribute("BirdID").toString();
			
			Update update=new Update();
			
			GetBirdGroup getGroup= new GetBirdGroup();
			GetBirdFamily getFamily=new GetBirdFamily();
			GetBirdSpecies getspecies=new GetBirdSpecies();
			GetPhotographer getPhotoGrap=new GetPhotographer();
			System.out.println(request.getParameter("species"));
			BirdSpecies species=getspecies.getSpeciesUseSPName(request.getParameter("species")).get(0);
			BirdFamily family=getFamily.getFamilyListToFMID(Integer.toString(species.getFamily_ID())).get(0);
			BirdGroup  group=getGroup.getGroupList(Integer.toString(family.getGroupID())).get(0);
			
			
			Photographer photoGrap=getPhotoGrap.getPhotographerListUsingName(request.getParameter("photographer")).get(0);
			
			Bird bird=new Bird();
			bird.setId(Integer.parseInt(num));
			bird.setImgUrl((String) sesForNum.getAttribute("Image"));
			bird.setFamily(family.getFamilyName());
			bird.setGroup(group.getGroupName());
			bird.setCommon_Name(request.getParameter("species"));
			bird.setSpecies(species.getSpecies_Name());
			bird.setSpecies_ID(species.getSpecies_ID());
			bird.setEquip(request.getParameter("equip"));
			bird.setDate(request.getParameter("Year")+"-"+request.getParameter("month")+"-"+request.getParameter("date"));
			bird.setOther_Name(request.getParameter("other"));
			bird.setLocation(request.getParameter("location"));
			bird.setPhotographerId(photoGrap.getPhotographer_ID());
			bird.setRemarks(request.getParameter("remarks"));
			update.updateBird(bird);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
