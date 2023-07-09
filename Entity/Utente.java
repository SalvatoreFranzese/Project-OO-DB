package com.smup.Entity;

public class Utente {
	private String id;
	private String username;
	private String password;
	private boolean isAdmin;

	public Utente(String id, String username, String password, Boolean isAdmin) {
		setId(id);
		setUsername(username);
		setPassword(password);
		setAdmin(isAdmin);
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
