package com.kerrrusha.playlistassistant.factory.artist;

import com.kerrrusha.playlistassistant.model.AbstractArtist;
import com.kerrrusha.playlistassistant.model.deezer.DeezerArtist;
import com.kerrrusha.playlistassistant.model.presentable.PresentableArtist;

public class PresentableArtistFactory {

	public static PresentableArtist createArtist(DeezerArtist deezerArtist) {
		PresentableArtist presentableArtist = new PresentableArtist();
		presentableArtist.setArtistName(deezerArtist.getArtistName());
		presentableArtist.setPhotoUrl(deezerArtist.getPhotoUrl());
		return presentableArtist;
	}

	public static PresentableArtist createEmpty() {
		return new PresentableArtist();
	}

	public static PresentableArtist parseArtist(AbstractArtist artist) {
		PresentableArtist presentableArtist = createEmpty();
		if (artist.getClass() == DeezerArtist.class) {
			DeezerArtist deezerArtist = (DeezerArtist) artist;
			presentableArtist.setArtistName(deezerArtist.getArtistName());
			presentableArtist.setPhotoUrl(deezerArtist.getPhotoUrl());
		}
		return presentableArtist;
	}
}
