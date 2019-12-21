package org.birdnestlanka.db;

import java.util.ArrayList;
import java.util.List;


import org.birdnestlanka.beans.BirdFamily;

import org.birdnestlanka.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GetBirdFamily {
	public List<BirdFamily> getFamilyList() {
		List<BirdFamily> list = new ArrayList<BirdFamily>();
		Session session=null;
		try {
		 
		HibernateUtil hiberUtil = new HibernateUtil();
		SessionFactory factory = hiberUtil.getSessionFactory();
		Transaction tx = null;
		 session = factory.openSession();
		

			tx = session.getTransaction();
			tx.begin();
			 Query query = session.createQuery("from BirdFamily");
		         list = query.list();
		        System.out.println(list);
			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
		return list;
	}
	public List<BirdFamily> getFamilyList(String GroupID) {
		List<BirdFamily> list = new ArrayList<BirdFamily>();
		Session session=null;
		try {
		 
		HibernateUtil hiberUtil = new HibernateUtil();
		SessionFactory factory = hiberUtil.getSessionFactory();
		Transaction tx = null;
		 session = factory.openSession();
		

			tx = session.getTransaction();
			tx.begin();
			 Query query = session.createQuery("from BirdFamily where groupID="+GroupID);
		         list = query.list();
		        System.out.println(list);
			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
		return list;
	}
	public List<BirdFamily> getFamilyListToFMID(String FamilyID) {
		List<BirdFamily> list = new ArrayList<BirdFamily>();
		Session session=null;
		try {
		 
		HibernateUtil hiberUtil = new HibernateUtil();
		SessionFactory factory = hiberUtil.getSessionFactory();
		Transaction tx = null;
		 session = factory.openSession();
		

			tx = session.getTransaction();
			tx.begin();
			 Query query = session.createQuery("from BirdFamily where familyID="+FamilyID);
		         list = query.list();
		        System.out.println(list);
			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
		return list;
	}
}