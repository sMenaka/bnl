package org.birdnestlanka.db;

import java.util.ArrayList;
import java.util.List;

import org.birdnestlanka.beans.Bird;
import org.birdnestlanka.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GetBird {
	public List<Bird> getBird() {	
		List<Bird> bdlist=new ArrayList<Bird>();
		Session session=null;
		try{
			HibernateUtil util=new HibernateUtil();
			SessionFactory factory=util.getSessionFactory();
			Transaction tx=null;
			session=factory.openSession();
			tx=session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from Bird");
			bdlist=query.list();
			tx.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			return bdlist;
		}
	}
	public List<Bird> getBird(String birdID) {	
		List<Bird> bdlist=new ArrayList<Bird>();
		Session session=null;
		try{
			HibernateUtil util=new HibernateUtil();
			SessionFactory factory=util.getSessionFactory();
			Transaction tx=null;
			session=factory.openSession();
			tx=session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from Bird where Bird_ID="+birdID);
			bdlist=query.list();
			tx.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			return bdlist;
		}
	}
	public List<Bird> getBirdSpesices(String SPID) {	
		List<Bird> bdlist=new ArrayList<Bird>();
		Session session=null;
		try{
			HibernateUtil util=new HibernateUtil();
			SessionFactory factory=util.getSessionFactory();
			Transaction tx=null;
			session=factory.openSession();
			tx=session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from Bird where Species_ID="+SPID);
			bdlist=query.list();
			tx.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			return bdlist;
		}
	}
	public List<Bird> getBirdSpesicesPGID(String PGID) {	
		List<Bird> bdlist=new ArrayList<Bird>();
		Session session=null;
		try{
			HibernateUtil util=new HibernateUtil();
			SessionFactory factory=util.getSessionFactory();
			Transaction tx=null;
			session=factory.openSession();
			tx=session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from Bird where photographerId="+PGID);
			bdlist=query.list();
			tx.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			return bdlist;
		}
	}
	public List<Bird> getBirdCommonName(String Common) {	
		List<Bird> bdlist=new ArrayList<Bird>();
		Session session=null;
		try{
			HibernateUtil util=new HibernateUtil();
			SessionFactory factory=util.getSessionFactory();
			Transaction tx=null;
			session=factory.openSession();
			tx=session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from Bird where Common_Name='"+Common+"'");
			bdlist=query.list();
			tx.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			return bdlist;
		}
	}
}
