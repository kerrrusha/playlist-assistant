package com.kerrrusha.playlistassistant.model;

public class Track {

	private String trackName;
	private String artistName;

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

	@Override
	public String toString() {
		return "Track{" +
				"trackName='" + trackName + '\'' +
				", artistName='" + artistName + '\'' +
				'}';
	}
}
