package com.smup.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.smup.Entity.EP;

public interface EPDAO {
	public void insertEP(String nome,  String genere, int songNumber, String artista, String dataPubblicazione);
	public void deleteEP(String codice);
	public void updateEP(String codice, String nome, String dataPubblicazione, String genere, int songNumber);
	public ResultSet stampaEP();
	public ArrayList<EP> getAllEP();
}