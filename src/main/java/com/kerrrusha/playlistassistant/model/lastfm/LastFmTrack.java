package com.kerrrusha.playlistassistant.model.lastfm;

import com.kerrrusha.playlistassistant.model.Track;

import java.util.Objects;

public class LastFmTrack extends Track {

	private int playcount;
	private String id, url, imageUrl;

	public LastFmTrack() {}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}

	public int getPlaycount() {
		return playcount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		LastFmTrack other = (LastFmTrack) o;

		return Objects.equals(getId(), other.getId()) &&
				getPlaycount() == other.getPlaycount() &&
				getArtistName().equals(other.getArtistName()) &&
				getTrackName().equals(other.getTrackName()) &&
				getUrl().equals(other.getUrl()) &&
				getImageUrl().equals(other.getImageUrl());
	}

	@Override
	public String toString() {
		return String.format("LastFmSong [\n" +
						"id = %s\n" +
						"playcount = %s\n" +
						"artistName = %s\n" +
						"name = %s\n" +
						"url = %s\n" +
						"imageUrl = %s\n" +
						"]",
				getId(),
				getPlaycount(),
				getArtistName(),
				getTrackName(),
				getUrl(),
				getImageUrl());
	}
}
