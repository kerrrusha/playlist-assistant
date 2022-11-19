package com.kerrrusha.playlistassistant.sound_parser.parser.deezer;

import com.kerrrusha.playlistassistant.model.deezer.DeezerArtist;
import com.kerrrusha.playlistassistant.sound_parser.mapper.deezer.DeezerArtistJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.deezer.DeezerArtistJsonProvider;

import java.io.IOException;

public class DeezerArtistParser {

	public DeezerArtist getArtist(String query) throws IOException {
		String responseJson = DeezerArtistJsonProvider.getResponse(query);
		return new DeezerArtistJsonMapper().fromJson(responseJson);
	}
}
