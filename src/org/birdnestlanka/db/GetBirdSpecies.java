package org.birdnestlanka.db;

import java.util.ArrayList;
import java.util.List;

import org.birdnestlanka.beans.BirdSpecies;
import org.birdnestlanka.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GetBirdSpecies {
	public List<BirdSpecies> getSpecies() {
		List<BirdSpecies> spList = new ArrayList<BirdSpecies>();
		Session session = null;
		try {
			HibernateUtil hiberutil = new HibernateUtil();
			SessionFactory factory = hiberutil.getSessionFactory();
			Transaction tx = null;
			session = factory.openSession();
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from BirdSpecies");
			spList = query.list();
			tx.commit();
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return spList;
	}
	public List<BirdSpecies> getSpecies(String familyID) {
		List<BirdSpecies> spList = new ArrayList<BirdSpecies>();
		Session session = null;
		try {
			HibernateUtil hiberutil = new HibernateUtil();
			SessionFactory factory = hiberutil.getSessionFactory();
			Transaction tx = null;
			session = factory.openSession();
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from BirdSpecies where family_ID="+familyID);
			System.out.println(spList);
			spList = query.list();
			tx.commit();
		} catch (Exception e) {
System.out.println(e);
		} finally {
			session.close();
		}
		return spList;
	}
	public List<BirdSpecies> getSpeciesUseSPName(String Common_name) {
		List<BirdSpecies> spList = new ArrayList<BirdSpecies>();
		Session session = null;
		try {
			HibernateUtil hiberutil = new HibernateUtil();
			SessionFactory factory = hiberutil.getSessionFactory();
			Transaction tx = null;
			session = factory.openSession();
			tx = session.getTransaction();
			tx.begin();
		
			try{Query query = session.createQuery("from BirdSpecies where common_Name='"+Common_name+"'");
			
			spList = query.list();
			tx.commit();
			}
			catch(Exception e){
				System.out.println(e);
			}
		} catch (Exception e) {
		
			System.out.println(e);
		} finally {
			session.close();
		}
		return spList;
	}
	public List<BirdSpecies> getSpeciesUseSPID(String Species_ID) {
		List<BirdSpecies> spList = new ArrayList<BirdSpecies>();
		Session session = null;
		try {
			HibernateUtil hiberutil = new HibernateUtil();
			SessionFactory factory = hiberutil.getSessionFactory();
			Transaction tx = null;
			session = factory.openSession();
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from BirdSpecies where species_ID="+Species_ID);
			
			spList = query.list();
			tx.commit();
		} catch (Exception e) {
System.out.println(e);
		} finally {
			session.close();
		}
		return spList;
	}
	public List<BirdSpecies> getSpeciesComm2(String comm2) {
		List<BirdSpecies> spList = new ArrayList<BirdSpecies>();
		Session session = null;
		try {
			HibernateUtil hiberutil = new HibernateUtil();
			SessionFactory factory = hiberutil.getSessionFactory();
			Transaction tx = null;
			session = factory.openSession();
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from BirdSpecies where common_Name2='"+comm2+"'");
			
			spList = query.list();
			tx.commit();
		} catch (Exception e) {
System.out.println(e);
		} finally {
			session.close();
		}
		return spList;
	}
}
