package com.kerrrusha.playlistassistant.model;

import java.io.Serializable;

public class UserSuitableTrack implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int userId;
	private String artistName;
	private String trackName;
	private String trackPhotoUrl;

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

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getTrackPhotoUrl() {
		return trackPhotoUrl;
	}

	public void setTrackPhotoUrl(String trackPhotoUrl) {
		this.trackPhotoUrl = trackPhotoUrl;
	}

	@Override
	public String toString() {
		return "UserSuitableTrack{" +
				"id=" + id +
				", userId=" + userId +
				", artistName='" + artistName + '\'' +
				", trackName='" + trackName + '\'' +
				", trackPhotoUrl='" + trackPhotoUrl + '\'' +
				'}';
	}
}
