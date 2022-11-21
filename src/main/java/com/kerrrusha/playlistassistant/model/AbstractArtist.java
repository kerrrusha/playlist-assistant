package com.kerrrusha.playlistassistant.model;

public class AbstractArtist implements Emptyable {

	protected String artistName;

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@Override
	public boolean isEmpty() {
		return artistName == null || artistName.isEmpty();
	}

	@Override
	public String toString() {
		return "Artist{" +
				", artistName='" + artistName + '\'' +
				'}';
	}
}
