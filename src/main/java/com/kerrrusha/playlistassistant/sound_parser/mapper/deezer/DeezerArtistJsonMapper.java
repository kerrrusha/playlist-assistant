package com.kerrrusha.playlistassistant.sound_parser.mapper.deezer;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.factory.artist.DeezerArtistFactory;
import com.kerrrusha.playlistassistant.model.deezer.DeezerArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;
import org.apache.log4j.Logger;

public class DeezerArtistJsonMapper extends GsonMapper {

	private static final Logger logger = Logger.getLogger(DeezerArtistJsonMapper.class);

	public DeezerArtist fromJson(String jsonString) {
		JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
		DeezerArtist artist = DeezerArtistFactory.createEmpty();

		try {
			final String name = jsonObject.get("name").getAsString();
			artist.setArtistName(name);

			final String photoUrl = jsonObject.get("picture").getAsString();
			artist.setPhotoUrl(photoUrl);
		} catch (Throwable e) {
			logger.warn(e.getMessage());
		}
		return artist;
	}

	public String toJson(LastFmArtist artist) {
		return gson.toJson(artist);
	}
}
