package com.smup.Entity;

public class Artista{
	private String fristName;
	private String lastName;
	private String nickname;
	private String id;
	private String birthDate;
	private String city;
	private int followers;

	public Artista(String id, String firstName, String lastName, String city, String birthDate, String nickname, int followers) {
		setId(id);
		setFristName(firstName);
		setLastName(lastName);
		setCity(city);
		setBirthDate(birthDate);
		setNickname(nickname);
		setFollowers(0);
	}
	
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}

	@Override
	public String toString() {
		return getId() + ", " + getNickname();
	}
}