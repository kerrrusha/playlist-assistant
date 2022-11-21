package com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm;

import java.io.IOException;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.getResponseString;

public class LastFmGenreTopTracksProvider {

	static final String API_KEY = "70375b3e1e3f4a5ed7f433270af4e3a2";
	static final String GENRE_TOP_TRACKS_URL = String.format("https://ws.audioscrobbler.com/2.0/?method=tag.gettoptracks&api_key=%s&format=json", API_KEY);

	public static String getResponse(String genreName, int limit) throws IOException {
		String url = GENRE_TOP_TRACKS_URL + "&tag=" + genreName + "&limit=" + limit;
		return getResponseString(url);
	}
}
