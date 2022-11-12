package com.kerrrusha.playlistassistant.factory.genre;

import com.kerrrusha.playlistassistant.model.AbstractGenre;

public class GenreFactory {

	public static AbstractGenre createGenre(String name) {
		AbstractGenre genre = new AbstractGenre();
		genre.setName(name);
		return genre;
	}
}
