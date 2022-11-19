package com.kerrrusha.playlistassistant.factory.artist;

import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;

public class LastFmArtistFactory {

	public static LastFmArtist createArtist(String artistName) {
		LastFmArtist artist = new LastFmArtist();
		artist.setArtistName(artistName);
		return artist;
	}
}
