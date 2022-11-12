package com.kerrrusha.playlistassistant.sound_parser.mapper.deezer;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.deezer.DeezerArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;

public class DeezerArtistJsonMapper extends GsonMapper {

	public DeezerArtist fromJson(String jsonString) {
		JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
		DeezerArtist artist = new DeezerArtist();

		final String name = jsonObject.get("name").getAsString();
		final String photoUrl = jsonObject.get("picture").getAsString();

		artist.setArtistName(name);
		artist.setPhotoUrl(photoUrl);

		return artist;
	}

	public String toJson(LastFmArtist artist) {
		return gson.toJson(artist);
	}
}
