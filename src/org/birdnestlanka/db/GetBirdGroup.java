package org.birdnestlanka.db;

import java.util.ArrayList;
import java.util.List;


import org.birdnestlanka.beans.BirdGroup;
import org.birdnestlanka.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GetBirdGroup {
	public List<BirdGroup> getGroupList() {
		List list = new ArrayList<BirdGroup>();
		Session session=null;
		try {
		 
		HibernateUtil hiberUtil = new HibernateUtil();
		SessionFactory factory = hiberUtil.getSessionFactory();
		Transaction tx = null;
		 session = factory.openSession();
		tx = session.getTransaction();
			tx.begin();
			 Query query = session.createQuery("from BirdGroup");
		         list = query.list();
		         tx.commit();
		         System.out.println("");
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return list;
	}
	public List<BirdGroup> getGroupList(String GroupID) {
		List list = new ArrayList<BirdGroup>();
		Session session=null;
		try {
		 
		HibernateUtil hiberUtil = new HibernateUtil();
		SessionFactory factory = hiberUtil.getSessionFactory();
		Transaction tx = null;
		 session = factory.openSession();
		tx = session.getTransaction();
			tx.begin();
			 Query query = session.createQuery("from BirdGroup where groupID="+GroupID);
		         list = query.list();
		         tx.commit();
		         System.out.println("");
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return list;
	}
}