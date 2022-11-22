package com.kerrrusha.playlistassistant.viewmodel;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;

import java.util.Collection;

public class SuitableTracksViewModel {

	private Collection<ItunesTrack> tracks;

	public Collection<ItunesTrack> getTracks() {
		return tracks;
	}

	public void setTracks(Collection<ItunesTrack> tracks) {
		this.tracks = tracks;
	}
}
