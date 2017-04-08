package data;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Telefonlar;
import utility.HibernateManagerUtility;

public class TelefonlarDataImp implements TelefonlarData {

	@Override
	public Telefonlar insertTelefonlar(Telefonlar i) {
		Session session = HibernateManagerUtility.getHibernateSession();
		Transaction tx = null;
		tx=session.beginTransaction();
		session.save(i);
		tx.commit();
		session.close();
		return i;
	}

	@Override
	public List<String> listAllTelefonlar(int id) {
		Session session = HibernateManagerUtility.getHibernateSession();
		Transaction tx = null;
		List <String> tel = null;
		System.out.println("verilen id ="+id);
		Query query = session.createQuery("From Telefonlar i where i.kisi.id= "+ id);
		tel= query.list();
		session.close();
		return tel;
	}

	@Override
	public void deleteTelefonlar(int id) {
		Session session = HibernateManagerUtility.getHibernateSession();
		Transaction tx = null;
		tx= session.beginTransaction();
		System.out.println("silinen tel ="+id);
		Telefonlar i = session.get(Telefonlar.class, id);
		session.delete(i);
		tx.commit();
		session.close();
		
	}

	
}
