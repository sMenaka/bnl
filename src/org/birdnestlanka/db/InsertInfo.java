package org.birdnestlanka.db;


import org.birdnestlanka.beans.Info;
import org.birdnestlanka.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class InsertInfo{


	public void addInfo(Info info) {
		
		try {
			
			HibernateUtil hiberutil=new HibernateUtil();
			SessionFactory factory=hiberutil.getSessionFactory();
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(info);
	        tx.commit();
	        
		} catch (Exception e) {
System.out.println(e);
		}
	}
}