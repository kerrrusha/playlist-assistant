package com.kerrrusha.playlistassistant.factory.artist;

import com.kerrrusha.playlistassistant.model.AbstractArtist;

public class ArtistFactory {

	public static AbstractArtist createArtist(String artistName) {
		AbstractArtist artist = new AbstractArtist();
		artist.setArtistName(artistName);
		return artist;
	}
}
