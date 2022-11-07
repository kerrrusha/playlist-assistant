package com.kerrrusha.playlistassistant.model;

public class Track extends Artist {

	protected String trackName;

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public boolean isEmpty() {
		return trackName.isEmpty();
	}

	@Override
	public String toString() {
		return "Track{" +
				"trackName='" + trackName + '\'' +
				", artistName='" + artistName + '\'' +
				'}';
	}
}
