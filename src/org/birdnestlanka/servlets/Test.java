package org.birdnestlanka.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.birdnestlanka.beans.Bird;
import org.birdnestlanka.beans.BirdFamily;
import org.birdnestlanka.beans.BirdGroup;
import org.birdnestlanka.beans.BirdSpecies;
import org.birdnestlanka.beans.Photographer;
import org.birdnestlanka.db.GetBirdFamily;
import org.birdnestlanka.db.GetBirdGroup;
import org.birdnestlanka.db.GetBirdSpecies;
import org.birdnestlanka.db.GetPhotographer;
import org.birdnestlanka.db.InsertBird;

/**
 * Servlet implementation class Test
 */

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "uploadedImage";

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newFileName = null;
		List<String> birdlist = new ArrayList<>();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {

			Iterator<FileItem> iterator = upload.parseRequest(request).iterator();
			File uploadedFile;
			String dirPath = "fileuploads";
			while (iterator.hasNext()) {

				FileItem item = iterator.next();
				if (!item.isFormField()) {

					String fileNameWithExt = item.getName();
					String fileName = new File(fileNameWithExt).getName();

					newFileName = "sss" + fileName;

					String filePath = uploadPath + File.separator + newFileName;
		
					File storeFile = new File(filePath);
					item.write(storeFile);
					request.setAttribute("message", "Upload has been done successfully!");
				} else {

					String otherFieldName = item.getFieldName();
					
					String otherFieldValue = item.getString();
					birdlist.add(otherFieldValue);

				}
			}
		} catch (Exception e) {

		}
		getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
		try {
			String spName = null;
			String comm=null;
			String lastGroup = null;
			int sp_ID = 0;
			int groupID = 0;
			String lastfamily = null;
			List<BirdFamily> familylist = null;
			int PhotographerId = 0;
			GetBirdSpecies bspecies = new GetBirdSpecies();
			List<BirdSpecies> family = bspecies

					.getSpeciesUseSPName(birdlist.get(0));
			for (BirdSpecies splist : family) {
				sp_ID = splist.getSpecies_ID();
				spName = splist.getSpecies_Name();
				comm=splist.getCommon_Name();
				int f_ID = splist.getFamily_ID();
				GetBirdFamily bfamily = new GetBirdFamily();
				familylist = bfamily.getFamilyListToFMID(Integer.toString(f_ID));
			}
			for (BirdFamily bf : familylist) {
				lastfamily = bf.getFamilyName();
				groupID = bf.getGroupID();
			}
			GetBirdGroup group = new GetBirdGroup();
			List<BirdGroup> groupList = group.getGroupList(Integer.toString(groupID));
			for (BirdGroup bg : groupList) {
				lastGroup = bg.getGroupName();
			}
			GetPhotographer getGrapher = new GetPhotographer();
			List<Photographer> PGrapherList = getGrapher.getPhotographerListUsingName(birdlist.get(5));
			for (Photographer pg : PGrapherList) {
				PhotographerId = pg.getPhotographer_ID();
			}
		
			Bird bird = new Bird();
			InsertBird conn = new InsertBird();
			bird.setCommon_Name(comm);
			bird.setSpecies(spName);
			bird.setOther_Name(birdlist.get(1));
			bird.setRemarks(birdlist.get(2));
			bird.setGroup(lastGroup);
			bird.setFamily(lastfamily);
			bird.setEquip(birdlist.get(4));
			bird.setPhotographerId(PhotographerId);
			bird.setDate(birdlist.get(6) + "-" + birdlist.get(7) + "-" + birdlist.get(8));
			String path = "uploadedImage/" + newFileName;
			System.out.println(path);
			bird.setSpecies_ID(sp_ID);
			bird.setImgUrl(path);
			bird.setLocation(birdlist.get(3));
			conn.addBird(bird);
			System.out.println(birdlist);

		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
