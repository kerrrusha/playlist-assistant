package com.kerrrusha.playlistassistant.model;

public class AbstractTrack extends AbstractArtist {

	protected String trackName;

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	@Override
	public boolean isEmpty() {
		return trackName == null || trackName.isEmpty();
	}

	@Override
	public String toString() {
		return "Track{" +
				"trackName='" + trackName + '\'' +
				", artistName='" + artistName + '\'' +
				'}';
	}
}
