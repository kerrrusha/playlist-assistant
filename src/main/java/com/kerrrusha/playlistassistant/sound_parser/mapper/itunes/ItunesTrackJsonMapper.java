package com.kerrrusha.playlistassistant.sound_parser.mapper.itunes;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class ItunesTrackJsonMapper extends GsonMapper {

	private static final Logger logger = Logger.getLogger(ItunesTrackJsonMapper.class);

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
		Collection<JsonElement> jsonList = new ArrayList<>();
		try {
			jsonList =JsonParser.parseString(json).getAsJsonObject().
					getAsJsonArray("results").asList();
		} catch (Throwable e) {
			logger.warn(json + System.lineSeparator() + e);
		}
		return jsonList;
	}

	public String toJson(ItunesTrack track) {
		return gson.toJson(track);
	}
}
