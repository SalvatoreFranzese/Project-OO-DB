package com.smup.DAO;

import com.smup.Entity.Utente;

public interface UtenteDAO {
	public void insertUser(String username, String password, boolean isAdmin);
	public Utente checkUser(String username, String password);
}