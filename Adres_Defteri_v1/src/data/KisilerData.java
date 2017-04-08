package data;

import java.util.List;


import model.Kisiler;

public interface KisilerData {

	public Kisiler insertKisiler(Kisiler kisiler);

	public Kisiler findKisiler(int input);

	public List<Kisiler> findAllKisiler(String input);

	public void removeKisiler(int id);
	
	public void setKisiler(int id,String ad,String soyad,String adres,String eposta);
	
	public List<Kisiler> listAllKisiler();
	
	
}
