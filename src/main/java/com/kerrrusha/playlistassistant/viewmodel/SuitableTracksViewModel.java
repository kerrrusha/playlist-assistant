package com.kerrrusha.playlistassistant.viewmodel;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;

import java.io.Serializable;
import java.util.Collection;

public class SuitableTracksViewModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<ItunesTrack> tracks;

	public Collection<ItunesTrack> getTracks() {
		return tracks;
	}

	public void setTracks(Collection<ItunesTrack> tracks) {
		this.tracks = tracks;
	}
}
