package com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmTrack;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm.LastFmTrackJsonProvider;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class LastFmTrackJsonMapper extends GsonMapper {

	public LastFmTrack fromJson(String jsonString) {
		JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
		LastFmTrack track = new LastFmTrack();

		final String id = jsonObject.get("mbid").getAsString();
		final int playcount = jsonObject.get("playcount").getAsInt();
		final String name = jsonObject.get("name").getAsString();
		final String artistName = jsonObject.get("artist").getAsJsonObject().get("name").getAsString();
		final String url = jsonObject.get("url").getAsString();
		final String imageUrl = jsonObject.get("album").getAsJsonObject().get("image").getAsJsonArray().asList().stream()
				.filter(elem -> elem.toString().contains("large"))
				.findFirst()
				.orElse(JsonParser.parseString(""))
				.getAsJsonObject().get("#text").getAsString();

		track.setId(id);
		track.setPlaycount(playcount);
		track.setTrackName(name);
		track.setArtistName(artistName);
		track.setUrl(url);
		track.setImageUrl(imageUrl);

		return track;
	}

	public Collection<LastFmTrack> collectionFromJson(String jsonString) {
		return jsonToElements(jsonString).stream()
				.map(this::jsonToId)
				.map(LastFmTrackJsonProvider::getResponse)
				.map(elem -> jsonToElement(elem).toString())
				.map(this::fromJson)
				.collect(toSet());
	}

	private static Collection<JsonElement> jsonToElements(String json) {
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		return jsonObject.getAsJsonObject("tracks").get("track").getAsJsonArray().asList();
	}

	private static JsonElement jsonToElement(String json) {
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		return jsonObject.get("track");
	}

	public String toJson(LastFmTrack song) {
		return gson.toJson(song);
	}

	public String jsonToId(JsonElement jsonElement) {
		return jsonElement.getAsJsonObject().get("mbid").getAsString();
	}
}
