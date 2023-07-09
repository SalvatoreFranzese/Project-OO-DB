package com.smup.Entity;

public class Singolo {
	private String id;
	private String name;
	private int duration;
	private String genre;
	private String artist;
	private Pubblica publications;

	public Singolo(String id, String name, int duration, String genre, Pubblica publications) {
		setId(id);
		setName(name);
		setDuration(duration);
		setGenre(genre);
		setPublications(publications);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Pubblica getPublications() {
		return publications;
	}
	public void setPublications(Pubblica publications) {
		this.publications = publications;
	}
}
