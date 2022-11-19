package com.kerrrusha.playlistassistant.sound_parser.cache;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;

import java.util.Collection;
import java.util.HashSet;

public class SoundDataCache {

	private Collection<LastFmGenre> topGenres;
	private Collection<LastFmArtist> topGenreArtists;
	private Collection<ItunesTrack> similarArtistsTopTracks;

	public SoundDataCache() {
		topGenres = new HashSet<>();
		topGenreArtists = new HashSet<>();
		similarArtistsTopTracks = new HashSet<>();
	}

	protected void copyValues(SoundDataCache otherCache) {
		setTopGenres(otherCache.getTopGenres());
		setTopGenreArtists(otherCache.getTopGenreArtists());
		setSimilarArtistsTopTracks(otherCache.getSimilarArtistsTopTracks());
	}

	public Collection<LastFmGenre> getTopGenres() {
		return topGenres;
	}

	protected void setTopGenres(Collection<LastFmGenre> topGenres) {
		this.topGenres = topGenres;
	}

	public Collection<LastFmArtist> getTopGenreArtists() {
		return topGenreArtists;
	}

	protected void setTopGenreArtists(Collection<LastFmArtist> topGenreArtists) {
		this.topGenreArtists = topGenreArtists;
	}

	public Collection<ItunesTrack> getSimilarArtistsTopTracks() {
		return similarArtistsTopTracks;
	}

	protected void setSimilarArtistsTopTracks(Collection<ItunesTrack> similarArtistsTopTracks) {
		this.similarArtistsTopTracks = similarArtistsTopTracks;
	}
}
