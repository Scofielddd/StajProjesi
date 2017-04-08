package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import data.KisilerDataImp;
import data.TelefonlarDataImp;
import model.Kisiler;
import model.Telefonlar;

@SessionScoped
@ManagedBean
public class KisilerController {

	
	private Kisiler add = new Kisiler();
	private Kisiler search = new Kisiler();
	private Telefonlar i = new Telefonlar();
	private List<Kisiler> kisiler = new ArrayList<Kisiler>();
	private List<String> telefonlar = new ArrayList<String>();
	private List<Kisiler> searchKisiler = new ArrayList<Kisiler>();
	private String input;
	
	
	public String addKisiler(){
		KisilerDataImp kisidao = new KisilerDataImp();
		Telefonlar telefon = new Telefonlar();
		Kisiler kisi = new Kisiler();
		kisi.setAd(add.getAd());
		kisi.setSoyad(add.getSoyad());
		kisi.setEposta(add.getEposta());
		kisi.setAdres(add.getAdres());
		kisi.getTelefon().add(telefon);
		telefon.setKisi(kisi);
		
		kisidao.insertKisiler(kisi);
		
		i.setTelefon("");
		add.setAd("");
		add.setSoyad("");
		add.setAdres("");
		add.setEposta("");
		return "index.xhtml?faces-redirect=true";
	}

	public void listAllKisiler() {
		KisilerDataImp kisidao = new KisilerDataImp();
		kisiler = kisidao.listAllKisiler();
	}
	
	public String removeKisiler() {
		KisilerDataImp kisiDAOImpl = new KisilerDataImp();
		kisiDAOImpl.removeKisiler(search.getId());
		return "index?faces-redirect=true";
	}
	
	public void findKisiler(){
		KisilerDataImp kisifind = new KisilerDataImp();
		Kisiler kisi = kisifind.findKisiler(search.getId());
		search.setAd(kisi.getAd());
		search.setSoyad(kisi.getSoyad());
		search.setAdres(kisi.getAdres());
		search.setEposta(kisi.getEposta());
	}
	
	public String Search(){
		if(!input.equals("")){
			KisilerDataImp kisidao1 = new KisilerDataImp();
			searchKisiler = kisidao1.findAllKisiler(input);
			return "index?faces-redirect=true";
		}else{
			searchKisiler = null;
		}
		return "index?faces-redirect=true";
	}
	
	public void listAllTelefonlar(){
//		int x ;
//		x=Integer.valueOf(id);
		TelefonlarDataImp telefondao = new TelefonlarDataImp();
		telefonlar = telefondao.listAllTelefonlar(search.getId());
		
	}
	
	public String updateKisiler(){
		if(!search.getAd().equals("") & !search.getSoyad().equals("") & !search.getEposta().equals("") & 
				!search.getAdres().equals("")){
			KisilerDataImp kisidao = new KisilerDataImp();
			kisidao.setKisiler(search.getId(), search.getAd(), search.getSoyad(), search.getAdres(), search.getEposta());
			return "index?faces-redirect=true";
		}
			else{
				System.err.println("Boş bırakmayınız");
				return "detay?faces-redirect=true";
			}
		
	}
	
	
	public String addTelefonlar(){
		if(!i.getTelefon().equals("")){
			KisilerDataImp kisidao = new KisilerDataImp();
			TelefonlarDataImp teldao = new TelefonlarDataImp();
			
			Telefonlar tel = new Telefonlar();
			Kisiler kisi = kisidao.findKisiler(search.getId());
			
			tel.setTelefon(i.getTelefon());
			kisi.getTelefon().add(tel);
			tel.setKisi(kisi);
			
			teldao.insertTelefonlar(tel);
			i.setTelefon("");
			return "true";
			
		}else{
			System.out.println("hata bosluk");
			return "error";
		}
	}
	
//	public String deleteTelefonlar(){
//		TelefonlarDataImp teldao = new TelefonlarDataImp();
//		teldao.deleteTelefonlar(i.getId());
//		return "true";
//	}
	
	public String deleteTelefonlar(){
		TelefonlarDataImp teldao = new TelefonlarDataImp();
		teldao.deleteTelefonlar(i.getId());
		return "true";
	}
	
	public String column(String ad,String soyad){
		return ad+ ' ' + soyad;
	}

	public Kisiler getAdd() {
		return add;
	}

	public void setAdd(Kisiler add) {
		this.add = add;
	}

	public Kisiler getSearch() {
		return search;
	}

	public void setSearch(Kisiler search) {
		this.search = search;
	}

	public Telefonlar getI() {
		return i;
	}

	public void setI(Telefonlar i) {
		this.i = i;
	}

	public List<Kisiler> getKisiler() {
		return kisiler;
	}

	public void setKisiler(List<Kisiler> kisiler) {
		this.kisiler = kisiler;
	}

	public List<String> getTelefonlar() {
		return telefonlar;
	}

	public void setTelefonlar(List<String> telefonlar) {
		this.telefonlar = telefonlar;
	}

	public List<Kisiler> getSearchKisiler() {
		return searchKisiler;
	}

	public void setSearchKisiler(List<Kisiler> searchKisiler) {
		this.searchKisiler = searchKisiler;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	
	
	
	
	
}
