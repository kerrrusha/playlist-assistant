package com.kerrrusha.playlistassistant.sound_parser.parser.lastfm;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmTrack;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmTrackJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.prepareTerm;
import static java.util.stream.Collectors.toCollection;

public class LastFmTrackParser {

	static final String API_KEY = "70375b3e1e3f4a5ed7f433270af4e3a2";
	static final String GENRE_TOP_TRACKS_URL = String.format("https://ws.audioscrobbler.com/2.0/?method=tag.gettoptracks&api_key=%s&format=json", API_KEY);
	static final String FIND_TRACK_URL = String.format("https://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key=%s&format=json", API_KEY);

	public Collection<LastFmTrack> getTopTracks(LastFmGenre genre, int limit) throws IOException {
		String genreTracksJson = getJsonTracksByGenre(genre.getName(), limit);
		LastFmTrackJsonMapper mapper = new LastFmTrackJsonMapper();
		return jsonToElements(genreTracksJson).stream()
				.map(mapper::jsonToId)
				.map(this::getJsonTrackById)
				.map(elem -> jsonToElement(elem).toString())
				.map(mapper::fromJson)
				.collect(toCollection(ArrayList<LastFmTrack>::new));
	}

	private String getJsonTracksByGenre(String genreName, int limit) throws IOException {
		String url = GENRE_TOP_TRACKS_URL + "&tag=" + prepareTerm(genreName) + "&limit=" + limit;
		return HttpGetterUtil.getResponseString(url);
	}

	private String getJsonTrackById(String id) {
		String url = FIND_TRACK_URL + "&mbid=" + id;
		try {
			return HttpGetterUtil.getResponseString(url);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	private static Collection<JsonElement> jsonToElements(String json) {
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		return jsonObject.getAsJsonObject("tracks").get("track").getAsJsonArray().asList();
	}

	private static JsonElement jsonToElement(String json) {
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		return jsonObject.get("track");
	}
}
