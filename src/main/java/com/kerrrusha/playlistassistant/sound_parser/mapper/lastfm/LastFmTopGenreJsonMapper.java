package com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class LastFmTopGenreJsonMapper extends GsonMapper {

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
		return jsonToElements(jsonString).stream()
				.map(JsonElement::toString)
				.map(this::fromJson)
				.collect(toSet());
	}

	private static Collection<JsonElement> jsonToElements(String json) {
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		return jsonObject.getAsJsonObject("toptags").get("tag").getAsJsonArray().asList();
	}

	public String toJson(LastFmGenre genre) {
		return gson.toJson(genre);
	}
}
