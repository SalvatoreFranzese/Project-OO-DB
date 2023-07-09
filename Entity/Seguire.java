package com.smup.Entity;

public class Seguire {
	private String id;
	private String nickname;
	
	public Seguire(String id, String nickname) {
		setId(id);
		setNickname(nickname);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
