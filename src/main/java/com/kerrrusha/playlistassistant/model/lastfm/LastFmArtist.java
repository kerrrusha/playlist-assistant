package com.kerrrusha.playlistassistant.model.lastfm;

import com.kerrrusha.playlistassistant.model.AbstractArtist;

import java.util.Collection;

public class LastFmArtist extends AbstractArtist {

	private String id;
	private String url;
	private int playcount;
	Collection<LastFmArtist> similar;
	Collection<LastFmGenre> genres;

	public LastFmArtist() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPlaycount() {
		return playcount;
	}

	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}

	public Collection<LastFmArtist> getSimilar() {
		return similar;
	}

	public void setSimilar(Collection<LastFmArtist> similar) {
		this.similar = similar;
	}

	public Collection<LastFmGenre> getGenres() {
		return genres;
	}

	public void setGenres(Collection<LastFmGenre> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "LastFmArtist{" +
				"id='" + id + '\'' +
				", url='" + url + '\'' +
				", playcount=" + playcount +
				", similar=" + similar +
				", genres=" + genres +
				", artistName='" + artistName + '\'' +
				'}';
	}
}
