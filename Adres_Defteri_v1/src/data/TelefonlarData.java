package data;

import java.util.List;

import model.Telefonlar;

public interface TelefonlarData {
	public Telefonlar insertTelefonlar(Telefonlar i);
	
	public List<String> listAllTelefonlar(int id);
	
	public void deleteTelefonlar(int id);
}
