package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;


@Entity
public class Kisiler {
	@TableGenerator(name="KS_GEN",allocationSize=1)
	@Id 
	@GeneratedValue(generator="KS_GEN")
	private int id;
	private String ad;
	private String soyad;
	private String adres;
	private String eposta;

	@OneToMany(mappedBy="kisi" ,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Collection<Telefonlar> telefon = new ArrayList<Telefonlar>();
	

	
	@Override
	public String toString() {
		return "Kisiler [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", adres=" + adres + ", eposta=" + eposta
				+ ", telefon=" + telefon + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public Collection<Telefonlar> getTelefon() {
		return telefon;
	}

	public void setTelefon(Collection<Telefonlar> telefon) {
		this.telefon = telefon;
	}
	
	
	
	
	
        
    
}
