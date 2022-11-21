package com.kerrrusha.playlistassistant.factory.artist;

import com.kerrrusha.playlistassistant.model.deezer.DeezerArtist;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DeezerArtistFactory {

	public static DeezerArtist createEmpty() {
		DeezerArtist artist = new DeezerArtist();
		artist.setArtistName(EMPTY);
		artist.setPhotoUrl(EMPTY);
		return artist;
	}
}
