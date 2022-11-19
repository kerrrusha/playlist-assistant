package com.kerrrusha.playlistassistant.sound_parser.provider.json.deezer;
import java.io.IOException;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.getResponseString;

public class DeezerArtistJsonProvider {

	static final String BASE_URL = "https://api.deezer.com/artist/";

	public static String getResponse(String artistName) throws IOException {
		final String url = BASE_URL + artistName;
		return getResponseString(url);
	}
}
