package com.smup.Entity;

public class Pubblica {
	private String releaseDate;
	private String artist;
	private String album;
	private String single;
	private String ep;

	public Pubblica(String releaseDate, String artist, String album, String single, String ep) {
		setReleaseDate(releaseDate);
		setArtist(artist);
		setAlbum(album);
		setSingle(single);
		setEp(ep);
	}

	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}

	public String getSingle() {
		return single;
	}
	public void setSingle(String single) {
		this.single = single;
	}

	public String getEp() {
		return ep;
	}
	public void setEp(String ep) {
		this.ep = ep;
	}
}
