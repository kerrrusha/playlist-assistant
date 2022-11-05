package com.kerrrusha.playlistassistant.sound_parser.parser.lastfm;

import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmGenreJsonMapper;
import com.kerrrusha.playlistassistant.util.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static java.util.stream.Collectors.toCollection;

public class LastFmTopGenreParser {

	static final String API_KEY = "70375b3e1e3f4a5ed7f433270af4e3a2";
	static final String BASE_URL = String.format("https://ws.audioscrobbler.com/2.0/?method=tag.getTopTags&api_key=%s&format=json", API_KEY);

	public Collection<LastFmGenre> getTopGenres() throws IOException {
		String responseJson = getResponseJsonString();
		final LastFmGenreJsonMapper mapper = new LastFmGenreJsonMapper();
		return Arrays.stream(JsonUtil.jsonToElements(responseJson))
				.map(mapper::fromJson)
				.collect(toCollection(ArrayList<LastFmGenre>::new));
	}

	private String getResponseJsonString() throws IOException {
		return HttpGetterUtil.getResponseString(BASE_URL);
	}
}
