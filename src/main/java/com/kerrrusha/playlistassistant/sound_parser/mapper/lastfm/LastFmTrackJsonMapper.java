package com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmTrack;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;

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

	public String toJson(LastFmTrack song) {
		return gson.toJson(song);
	}

	public String jsonToId(JsonElement jsonElement) {
		return jsonElement.getAsJsonObject().get("mbid").getAsString();
	}
}
