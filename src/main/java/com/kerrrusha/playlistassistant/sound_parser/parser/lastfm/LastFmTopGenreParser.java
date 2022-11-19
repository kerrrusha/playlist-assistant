package com.kerrrusha.playlistassistant.sound_parser.parser.lastfm;

import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmTopGenreJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm.LastFmTopGenreJsonProvider;

import java.io.IOException;
import java.util.Collection;

public class LastFmTopGenreParser {

	public Collection<LastFmGenre> getTopGenres() throws IOException {
		String responseJson = LastFmTopGenreJsonProvider.getResponse();
		return new LastFmTopGenreJsonMapper().collectionFromJson(responseJson);
	}
}
