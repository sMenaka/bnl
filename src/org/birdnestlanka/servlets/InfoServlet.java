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
import org.birdnestlanka.beans.Info;
import org.birdnestlanka.beans.Photographer;
import org.birdnestlanka.db.GetBirdFamily;
import org.birdnestlanka.db.GetBirdGroup;
import org.birdnestlanka.db.GetBirdSpecies;
import org.birdnestlanka.db.GetPhotographer;
import org.birdnestlanka.db.InsertBird;
import org.birdnestlanka.db.InsertInfo;

/**
 * Servlet implementation class Test
 */

public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "uploadedSound";

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoServlet() {
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
		List<String> infoList = new ArrayList<>();
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

					newFileName = "bnl" + fileName;
					
					String filePath = uploadPath + File.separator + newFileName;
					
					File storeFile = new File(filePath);
					item.write(storeFile);
					request.setAttribute("message", "Upload has been done successfully!");
				} else {

					String otherFieldName = item.getFieldName();
					System.out.println(otherFieldName);
					String otherFieldValue = item.getString();
					infoList.add(otherFieldValue);

				}
			}
		} catch (Exception e) {

		}
		getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
		try {
			int sp_id = 0;
			GetBirdSpecies birdSp = new GetBirdSpecies();

			List<BirdSpecies> splist = birdSp.getSpeciesUseSPName(infoList.get(0));

			for (BirdSpecies sp : splist) {
				sp_id = sp.getSpecies_ID();

			}
			Info info = new Info();
			InsertInfo add = new InsertInfo();
			info.setSound_Url("uploadedSound/" + newFileName);
			info.setSpecies_ID(sp_id);
			info.setDescrip(infoList.get(1));

			add.addInfo(info);

		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
