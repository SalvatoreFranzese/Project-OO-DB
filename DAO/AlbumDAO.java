package com.smup.DAO;

import java.util.ArrayList;
import com.smup.Entity.Album;

public interface AlbumDAO {
	public void insertAlbum(String codice, String nome, int songNumber, String genere, String data, String artista);
	public void deleteAlbum(String codice);
	public void updateAlbum(String codice, String nome, int songNumber, String genere, String data);
	public ArrayList<Album> getAllAlbums();
}
