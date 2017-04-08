package utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManagerUtility {

	private static SessionFactory sessionFactory;
	static{
		try{
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static Session getHibernateSession(){
		return sessionFactory.openSession();
	}

}
