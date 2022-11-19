package com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm;

import java.io.IOException;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.getResponseString;

public class LastFmTopGenreJsonProvider {

	static final String API_KEY = "70375b3e1e3f4a5ed7f433270af4e3a2";
	static final String BASE_URL = String.format("https://ws.audioscrobbler.com/2.0/?method=tag.getTopTags&api_key=%s&format=json", API_KEY);

	public static String getResponse() throws IOException {
		return getResponseString(BASE_URL);
	}
}
