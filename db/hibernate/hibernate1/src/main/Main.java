package main;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javabeans.Personnes;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Configuration config = new Configuration();
		config.addClass(Personnes.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Personnes personne = new Personnes("nom1", "prenom1", new Date());
			session.save(personne);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
				throw e;
			}
		} finally {
			session.close();
		}
		
		sessionFactory.close();
	}

}
