package com.kerrrusha.playlistassistant.viewmodel;

import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;

import java.util.Collection;

public class SetFavouriteArtistsViewModel {

	private Collection<LastFmArtist> artists;

	public Collection<LastFmArtist> getArtists() {
		return artists;
	}

	public void setArtists(Collection<LastFmArtist> artists) {
		this.artists = artists;
	}
}
