package com.kerrrusha.playlistassistant.sound_parser.mapper.itunes;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;

import java.util.Arrays;
import java.util.Collection;

import static com.kerrrusha.playlistassistant.util.SubstringUtil.substringBetween;
import static java.util.stream.Collectors.toSet;

public class ItunesTrackJsonMapper extends GsonMapper {

	public ItunesTrack fromJson(String jsonString) {
		return gson.fromJson(jsonString, ItunesTrack.class);
	}

	public Collection<ItunesTrack> collectionFromJson(String jsonString) {
		return Arrays.stream(jsonToElements(jsonString))
				.map(this::fromJson)
				.collect(toSet());
	}

	private static String[] jsonToElements(String json) {
		String rawJson = json.replaceAll("},", "}");
		String onlyElements = substringBetween(rawJson, ": [", "]\n}");
		return onlyElements.split("(?<=})");
	}

	public String songToJson(ItunesTrack song) {
		return gson.toJson(song);
	}
}
