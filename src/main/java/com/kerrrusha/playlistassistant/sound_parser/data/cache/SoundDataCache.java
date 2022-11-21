package com.kerrrusha.playlistassistant.sound_parser.data.cache;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.model.presentable.PresentableArtist;

public class SoundDataCache {

	private SoundDataEntry<LastFmGenre> topGenres;
	private SoundDataEntry<LastFmArtist> topGenreArtists;
	private SoundDataEntry<PresentableArtist> presentableTopGenreArtists;
	private SoundDataEntry<ItunesTrack> similarArtistsTopTracks;

	public SoundDataCache() {
		topGenres = new SoundDataEntry<>();
		topGenreArtists = new SoundDataEntry<>();
		presentableTopGenreArtists = new SoundDataEntry<>();
		similarArtistsTopTracks = new SoundDataEntry<>();
	}

	protected void setValues(SoundDataCache otherCache) {
		setTopGenres(otherCache.getTopGenres());
		setTopGenreArtists(otherCache.getTopGenreArtists());
		setPresentableTopGenreArtists(otherCache.getPresentableTopGenreArtists());
		setSimilarArtistsTopTracks(otherCache.getSimilarArtistsTopTracks());
	}

	protected int removeEmptyValues() {
		int totalRemoved = 0;

		totalRemoved += topGenres.removeEmptyValues();
		totalRemoved += topGenreArtists.removeEmptyValues();
		totalRemoved += presentableTopGenreArtists.removeEmptyValues();
		totalRemoved += similarArtistsTopTracks.removeEmptyValues();

		return totalRemoved;
	}

	@Override
	public String toString() {
		return "Top genres - " + getTopGenres().size() + System.lineSeparator() +
				"Top genre artists - " + getTopGenreArtists().size() + System.lineSeparator() +
				"Presentable top genre artists - " + getPresentableTopGenreArtists().size() + System.lineSeparator() +
				"Similar artists top tracks - " + getSimilarArtistsTopTracks().size();
	}

	public SoundDataEntry<LastFmGenre> getTopGenres() {
		return topGenres;
	}

	public void setTopGenres(SoundDataEntry<LastFmGenre> topGenres) {
		this.topGenres = topGenres;
	}

	public SoundDataEntry<LastFmArtist> getTopGenreArtists() {
		return topGenreArtists;
	}

	public void setTopGenreArtists(SoundDataEntry<LastFmArtist> topGenreArtists) {
		this.topGenreArtists = topGenreArtists;
	}

	public SoundDataEntry<PresentableArtist> getPresentableTopGenreArtists() {
		return presentableTopGenreArtists;
	}

	public void setPresentableTopGenreArtists(SoundDataEntry<PresentableArtist> presentableTopGenreArtists) {
		this.presentableTopGenreArtists = presentableTopGenreArtists;
	}

	public SoundDataEntry<ItunesTrack> getSimilarArtistsTopTracks() {
		return similarArtistsTopTracks;
	}

	public void setSimilarArtistsTopTracks(SoundDataEntry<ItunesTrack> similarArtistsTopTracks) {
		this.similarArtistsTopTracks = similarArtistsTopTracks;
	}
}

