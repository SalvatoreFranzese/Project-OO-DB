package com.smup.Entity;

public class Album {
	private String id;
	private String name;
	private String genre;
	private int numberSongs;
	private Pubblica publications;

	public Album(String id, String name, String genre, int numberSongs) {
		setId(id);
		setName(name);
		setGenre(genre);
		setNumberSongs(numberSongs);
	}

	public Album(String id, String name, String genre, int numberSongs, Pubblica publications) {
		setId(id);
		setName(name);
		setGenre(genre);
		setNumberSongs(numberSongs);
		setPublications(publications);
	}

	public int getNumberSongs() {
		return numberSongs;
	}
	public void setNumberSongs(int numberSongs) {
		this.numberSongs = numberSongs;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public Pubblica getPublications() {
		return publications;
	}
	public void setPublications(Pubblica publications) {
		this.publications = publications;
	}

	@Override
	public String toString() {
		return getId() + ", " + getName();
	}
}
