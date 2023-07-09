package com.smup.DAO;

import com.smup.Entity.Brano;

import java.util.ArrayList;

public interface SongDAO {
	public void insertSongDB(String nome, int durata, String genere, String album);
	public void deleteSong(String codice);
	public void updateSong(String codice, String nome, int durata);
	public ArrayList<Brano> getAllSongs();
}
