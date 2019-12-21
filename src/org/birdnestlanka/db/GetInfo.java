package org.birdnestlanka.db;

import java.util.ArrayList;
import java.util.List;

import org.birdnestlanka.beans.Info;
import org.birdnestlanka.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GetInfo {
public List<Info> outInfo(){
	List<Info> infoList=new ArrayList<Info>();
	Session session=null;
	try {
		 
		HibernateUtil hiberUtil = new HibernateUtil();
		SessionFactory factory = hiberUtil.getSessionFactory();
		Transaction tx = null;
		 session = factory.openSession();
		

			tx = session.getTransaction();
			tx.begin();
			 Query query = session.createQuery("from Info");
		         infoList = query.list();
		       
			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
		return infoList;
	}
public List<Info> outInfo(String spID){
List<Info> infoList=new ArrayList<Info>();
Session session=null;
try {
	 
	HibernateUtil hiberUtil = new HibernateUtil();
	SessionFactory factory = hiberUtil.getSessionFactory();
	Transaction tx = null;
	 session = factory.openSession();
	

		tx = session.getTransaction();
		tx.begin();
		 Query query = session.createQuery("from Info where Species_ID="+spID);
	         infoList = query.list();
	       
		tx.commit();
	} catch (Exception e) {
		System.out.print(e);
	} finally {
		session.close();
	}
	return infoList;
}
}
