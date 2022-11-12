package com.kerrrusha.playlistassistant.sound_parser.parser.deezer;

import com.kerrrusha.playlistassistant.model.deezer.DeezerArtist;
import com.kerrrusha.playlistassistant.sound_parser.mapper.deezer.DeezerArtistJsonMapper;

import java.io.IOException;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.getResponseString;
import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.prepareTerm;

public class DeezerArtistParser {

	static final String BASE_URL = "https://api.deezer.com/artist/";

	public DeezerArtist getArtist(String query) throws IOException {
		query = prepareTerm(query);

		String responseJson = getResponseJsonStringFromTerm(query);
		return new DeezerArtistJsonMapper().fromJson(responseJson);
	}

	private String getResponseJsonStringFromTerm(String query) throws IOException {
		final String url = BASE_URL + query;
		return getResponseString(url);
	}
}
