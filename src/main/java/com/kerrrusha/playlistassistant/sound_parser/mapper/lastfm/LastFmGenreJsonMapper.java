package com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm;

import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;

public class LastFmGenreJsonMapper extends GsonMapper {

	public LastFmGenre fromJson(String jsonString) {
		return gson.fromJson(jsonString, LastFmGenre.class);
	}

	public String toJson(LastFmGenre genre) {
		return gson.toJson(genre);
	}
}
