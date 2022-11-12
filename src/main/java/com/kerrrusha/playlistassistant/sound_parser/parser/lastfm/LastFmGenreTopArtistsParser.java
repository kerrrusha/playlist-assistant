package com.kerrrusha.playlistassistant.sound_parser.parser.lastfm;

import com.kerrrusha.playlistassistant.model.AbstractGenre;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmArtistJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.provider.lastfm.LastFmGenreTopArtistsJsonProvider;

import java.io.IOException;
import java.util.Collection;

public class LastFmGenreTopArtistsParser {

	public Collection<LastFmArtist> getTopArtists(AbstractGenre genre) throws IOException {
		String artistsJson = LastFmGenreTopArtistsJsonProvider.getResponse(genre.getName());
		return new LastFmArtistJsonMapper().collectionFromJson(artistsJson);
	}
}
