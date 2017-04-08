package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import model.Kisiler;

@Entity
public class Telefonlar {
	@TableGenerator(name="ILT_GEN",allocationSize=1)
	@Id 
	@GeneratedValue(generator="ILT_GEN")
	private int id;
	
	private String telefon;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kisi_id")
	private Kisiler kisi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public Kisiler getKisi() {
		return kisi;
	}
	public void setKisi(Kisiler kisi) {
		this.kisi = kisi;
	}
	
	
}
