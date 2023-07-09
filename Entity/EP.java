package com.smup.Entity;

public class EP {
	private String id;
	private String name;
	private int songNumer;
	private String genre;
	private Pubblica publications;

	public EP(String id, String name, int songNumber, String genre, Pubblica publications) {
		setId(id);
		setName(name);
		setSongNumer(songNumber);
		setGenre(genre);
		setPublications(publications);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getSongNumer() {
		return songNumer;
	}
	public void setSongNumer(int songNumer) {
		this.songNumer = songNumer;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Pubblica getPublications() {
		return publications;
	}
	public void setPublications(Pubblica publications) {
		this.publications = publications;
	}
}
