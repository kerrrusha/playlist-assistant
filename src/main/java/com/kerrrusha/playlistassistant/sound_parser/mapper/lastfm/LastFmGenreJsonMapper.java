package com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;
import com.kerrrusha.playlistassistant.util.JsonUtil;

import java.util.Arrays;
import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class LastFmGenreJsonMapper extends GsonMapper {

	public LastFmGenre fromJson(String jsonString) {
		final JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
		LastFmGenre genre = new LastFmGenre();

		final String name = jsonObject.get("name").getAsString();
		final int count = jsonObject.get("count").getAsInt();

		genre.setName(name);
		genre.setCount(count);

		return genre;
	}

	public Collection<LastFmGenre> collectionFromJson(String jsonString) {
		return Arrays.stream(JsonUtil.jsonToElements(jsonString))
				.map(this::fromJson)
				.collect(toSet());
	}

	public String toJson(LastFmGenre genre) {
		return gson.toJson(genre);
	}
}
