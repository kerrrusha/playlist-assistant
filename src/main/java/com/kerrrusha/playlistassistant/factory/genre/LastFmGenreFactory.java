package com.kerrrusha.playlistassistant.factory.genre;

import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;

public class LastFmGenreFactory {

	public static LastFmGenre createGenre(String name) {
		LastFmGenre genre = new LastFmGenre();
		genre.setName(name);
		return genre;
	}
}
