package org.birdnestlanka.hibernate;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	SessionFactory sesFac = null;

	public SessionFactory getSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			sesFac = cfg.buildSessionFactory();

		} catch (Exception e) {
			System.out.println(e);
		}
		return sesFac;
	}
}
