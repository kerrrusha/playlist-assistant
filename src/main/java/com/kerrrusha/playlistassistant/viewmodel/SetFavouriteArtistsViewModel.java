package com.kerrrusha.playlistassistant.viewmodel;

import com.kerrrusha.playlistassistant.model.presentable.PresentableArtist;

import java.util.Collection;

public class SetFavouriteArtistsViewModel {

	private Collection<PresentableArtist> artists;

	public Collection<PresentableArtist> getArtists() {
		return artists;
	}

	public void setArtists(Collection<PresentableArtist> artists) {
		this.artists = artists;
	}
}
