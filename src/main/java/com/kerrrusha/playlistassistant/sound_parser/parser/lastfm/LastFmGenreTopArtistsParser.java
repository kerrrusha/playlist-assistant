package com.kerrrusha.playlistassistant.sound_parser.parser.lastfm;

import com.kerrrusha.playlistassistant.model.AbstractGenre;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmTopArtistsJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm.LastFmGenreTopArtistsJsonProvider;

import java.io.IOException;
import java.util.Collection;

public class LastFmGenreTopArtistsParser {

	public Collection<LastFmArtist> getTopArtists(AbstractGenre genre) throws IOException {
		String artistsJson = LastFmGenreTopArtistsJsonProvider.getResponse(genre.getName());
		return new LastFmTopArtistsJsonMapper().collectionFromJson(artistsJson);
	}
}
