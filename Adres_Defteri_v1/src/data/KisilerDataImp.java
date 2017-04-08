package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Kisiler;
import utility.HibernateManagerUtility;

public class KisilerDataImp implements KisilerData {

	@Override
	public Kisiler insertKisiler(Kisiler kisiler) {
		Session session = HibernateManagerUtility.getHibernateSession();
		Transaction tx=null;
		try{
			tx = session.beginTransaction();
			System.out.println("eklenen kullanıcının adı ve soyadı :" + kisiler.getAd() + " " + kisiler.getSoyad());
			session.save(kisiler);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		session.close();
		return kisiler;
	}

	@Override
	public Kisiler findKisiler(int input) {
		Session session = HibernateManagerUtility.getHibernateSession();
		Transaction tx = null;
		Kisiler kisi = null;
		kisi= session.get(Kisiler.class, input);
		System.out.println("find kullanıcı ad = "+kisi.getAd()+"soyad = "+kisi.getSoyad());
		session.close();
		return kisi;
	}

	@Override
	public List<Kisiler> findAllKisiler(String input) {
		Session session = HibernateManagerUtility.getHibernateSession();
		Transaction tx = null;
		List<Kisiler> Liste = new ArrayList<Kisiler>();
		System.out.println("aranan kelime = "+input);
		tx= session.beginTransaction();
		Query query = session.createQuery("select add from Kisiler add where "
				+"add.ad like :input or add.soyad like :"
				+ "input");
		query.setParameter("input", "%"+input+"%");
		Liste = query.list();
		session.close();
		return Liste;
	}

	@Override
	public void removeKisiler(int id) {
		Session session = HibernateManagerUtility.getHibernateSession();
		Transaction tx = null;
		tx=session.beginTransaction();
		Kisiler kisi = session.get(Kisiler.class, id);
		System.out.println("silincek eleman :"+kisi.getAd());
		session.delete(kisi);
		tx.commit();
		session.close();
		
	}

	@Override
	public void setKisiler(int id, String ad, String soyad, String adres, String eposta) {
		Session session = HibernateManagerUtility.getHibernateSession();
		Transaction tx =null;
		tx= session.beginTransaction();
		Kisiler kisi = session.get(Kisiler.class, id);
		System.out.println("silinecek kullanıcı  :"+kisi.getAd()+" soyadi :"+kisi.getSoyad());
		kisi.setAd(ad);
		kisi.setSoyad(soyad);
		kisi.setEposta(eposta);
		kisi.setAdres(adres);
		session.update(kisi);
		tx.commit();
		session.close();
		
		
	}

	@Override
	public List<Kisiler> listAllKisiler() {
		Session session = HibernateManagerUtility.getHibernateSession();
		Transaction tx = null;
		List<Kisiler> kisiler = null;
		
		tx=session.beginTransaction();
		kisiler = session.createQuery("FROM Kisiler").list();
		System.out.println("allList ");
		for(Iterator<Kisiler> iterator = kisiler.iterator();iterator.hasNext();)
		{
			Kisiler kisi = (Kisiler) iterator.next();
		}
		session.close();
		return kisiler;
	}

	
}