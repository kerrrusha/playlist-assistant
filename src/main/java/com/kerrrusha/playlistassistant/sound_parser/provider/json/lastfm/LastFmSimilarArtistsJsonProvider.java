package com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm;

import java.io.IOException;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.getResponseString;

public class LastFmSimilarArtistsJsonProvider {

	static final String API_KEY = "70375b3e1e3f4a5ed7f433270af4e3a2";
	static final String BASE_URL = String.format("https://ws.audioscrobbler.com/2.0/?method=artist.getsimilar&api_key=%s&format=json", API_KEY);

	public static String getResponse(String artistName) throws IOException {
		String url = BASE_URL + "&artist=" + artistName;
		return getResponseString(url);
	}

	public static String getResponse(String artistName, int limit) throws IOException {
		String url = BASE_URL + "&artist=" + artistName + "&limit=" + limit;
		return getResponseString(url);
	}
}
