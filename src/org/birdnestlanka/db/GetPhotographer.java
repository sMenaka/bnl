package org.birdnestlanka.db;

import java.util.ArrayList;
import java.util.List;

import org.birdnestlanka.beans.Photographer;
import org.birdnestlanka.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GetPhotographer {
	public List<Photographer> getPhotographerList() {
		List<Photographer> PhotographerList=new ArrayList<Photographer>();
		Session session=null;
		try{
			HibernateUtil util=new HibernateUtil();
			SessionFactory factory=util.getSessionFactory();
			Transaction tx=null;
			session=factory.openSession();
			tx=session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from Photographer");
			PhotographerList=query.list();
			System.out.println(PhotographerList);
			tx.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			return PhotographerList;
		}
	}
	public List<Photographer> getPhotographerList(String ID) {
		List<Photographer> PhotographerList=new ArrayList<Photographer>();
		Session session=null;
		try{
			HibernateUtil util=new HibernateUtil();
			SessionFactory factory=util.getSessionFactory();
			Transaction tx=null;
			session=factory.openSession();
			tx=session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from Photographer where photographer_ID="+ID);
			PhotographerList=query.list();
			System.out.println(PhotographerList);
			tx.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			return PhotographerList;
		}
	}
	public List<Photographer> getPhotographerListUsingName(String Name) {
		List<Photographer> PhotographerList=new ArrayList<Photographer>();
		Session session=null;
		try{
			HibernateUtil util=new HibernateUtil();
			SessionFactory factory=util.getSessionFactory();
			Transaction tx=null;
			session=factory.openSession();
			tx=session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from Photographer where photographer_Name='"+Name+"'");
			PhotographerList=query.list();
			tx.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			return PhotographerList;
		}
	}
}
