package com.smup.Entity;

public class Brano {
	private String id;
	private String name;
	private int duration;
	private String genre;
	private String album;

	public Brano(String id, String name, int duration, String genre, String album) {
		setId(id);
		setName(name);
		setDuration(duration);
		setGenre(genre);
		setAlbum(album);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
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

	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
}
