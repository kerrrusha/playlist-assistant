package com.kerrrusha.playlistassistant.sound_parser.mapper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.model.presentable.PresentableArtist;

import java.util.Collection;

public class PresentableArtistJsonMapper {

	public PresentableArtist fromJson(String jsonString) {
		JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
		PresentableArtist artist = new PresentableArtist();

		final String name = jsonObject.get("name").getAsString();

		artist.setArtistName(name);

		return artist;
	}
}
