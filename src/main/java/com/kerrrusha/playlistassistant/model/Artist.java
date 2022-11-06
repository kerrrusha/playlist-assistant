package com.kerrrusha.playlistassistant.model;

public class Artist {

	protected String artistName;

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@Override
	public String toString() {
		return "Artist{" +
				", artistName='" + artistName + '\'' +
				'}';
	}
}
