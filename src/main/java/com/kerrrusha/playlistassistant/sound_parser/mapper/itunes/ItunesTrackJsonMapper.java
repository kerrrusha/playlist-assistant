package com.kerrrusha.playlistassistant.sound_parser.mapper.itunes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class ItunesTrackJsonMapper extends GsonMapper {

	public ItunesTrack fromJson(String jsonString) {
		return gson.fromJson(jsonString, ItunesTrack.class);
	}

	public Collection<ItunesTrack> collectionFromJson(String jsonString) {
		return jsonToElements(jsonString).stream()
				.map(JsonElement::toString)
				.map(this::fromJson)
				.collect(toSet());
	}

	private static Collection<JsonElement> jsonToElements(String json) {
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		return jsonObject.getAsJsonArray("results").asList();
	}

	public String toJson(ItunesTrack track) {
		return gson.toJson(track);
	}
}
