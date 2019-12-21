package org.birdnestlanka.db;

import org.birdnestlanka.beans.Bird;
import org.birdnestlanka.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Update {

	public void updateBird(Bird bird){
		HibernateUtil hiberUtil=new HibernateUtil();
		SessionFactory sessionFac=hiberUtil.getSessionFactory();
		Session session=sessionFac.openSession();
		
		
		Transaction tx=null;
		try{
		tx=session.getTransaction();
		tx.begin();
		session.update(bird);
		tx.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			session.close();
		}
	}
}
