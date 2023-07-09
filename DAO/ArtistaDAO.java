package com.smup.DAO;

import java.util.ArrayList;
import com.smup.Entity.Artista;

public interface ArtistaDAO {
	public void insertArtist(String codice, String nome, String cognome, String dataNascita, String citta, String nomeDArte);
	public void deleteArtist(String codice);
	public void updateArtist(String codice, String nome, String cognome, String dataNascita, String citta, int followers, String nomeDArte);
	
	public ArrayList<Artista> getAllArtists();
	public ArrayList<Artista> getAllArtists(String id_User);
	public ArrayList<Artista> searchArtist(String nomeDaCercare, String id_User);
}