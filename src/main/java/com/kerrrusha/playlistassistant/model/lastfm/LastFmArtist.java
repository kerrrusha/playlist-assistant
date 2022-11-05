package com.kerrrusha.playlistassistant.model.lastfm;

import java.util.Collection;

public class LastFmArtist {

	private String id;
	private String name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
				", name='" + name + '\'' +
				", url='" + url + '\'' +
				", playcount=" + playcount +
				", similar=" + similar +
				", genres=" + genres +
				'}';
	}
}
