package com.kerrrusha.playlistassistant.model;

public class UserSelectedArtist {

	private int id;
	private int userId;
	private String artistName;
	private String artistPhotoUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistPhotoUrl() {
		return artistPhotoUrl;
	}

	public void setArtistPhotoUrl(String artistPhotoUrl) {
		this.artistPhotoUrl = artistPhotoUrl;
	}

	@Override
	public String toString() {
		return "UserSelectedArtist{" +
				"id=" + id +
				", userId=" + userId +
				", artistName='" + artistName + '\'' +
				", artistPhotoUrl='" + artistPhotoUrl + '\'' +
				'}';
	}
}
