package org.birdnestlanka.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.birdnestlanka.beans.Bird;
import org.birdnestlanka.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HibernateUtil hiberUtil=new HibernateUtil();
		HttpSession sessDelete=request.getSession();
		SessionFactory sessionFac=hiberUtil.getSessionFactory();
		Session session=null;
		try{
			
			session=sessionFac.openSession();
			Transaction tx=null;
			Bird bird=new Bird();
			bird.setId(Integer.parseInt(request.getParameter("ID")));
			bird.setCommon_Name(request.getParameter("comn"));
			bird.setImgUrl(request.getParameter("comn"));
			bird.setDate("2104-05-05");
			bird.setEquip("camera");
			bird.setFamily("ddd");
			bird.setGroup("g");
			bird.setSpecies("sp");
			bird.setLocation("l");
			tx=session.getTransaction();
			tx.begin();
			session.delete(bird);
			tx.commit();
		}
		catch(Exception e){
			System.out.print(e);
		}
		finally{
			session.close();
		}
		
	}

}
