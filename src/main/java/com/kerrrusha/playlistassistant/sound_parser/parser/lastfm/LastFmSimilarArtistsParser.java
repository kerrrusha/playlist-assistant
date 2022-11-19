package com.kerrrusha.playlistassistant.sound_parser.parser.lastfm;

import com.kerrrusha.playlistassistant.model.AbstractArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmSimilarArtistsJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm.LastFmSimilarArtistsJsonProvider;

import java.io.IOException;
import java.util.Collection;

public class LastFmSimilarArtistsParser {

	public Collection<LastFmArtist> getSimilarArtists(AbstractArtist artist) throws IOException {
		return getSimilarArtists(artist, 50);
	}

	public Collection<LastFmArtist> getSimilarArtists(AbstractArtist artist, int limit) throws IOException {
		String artistsJson = LastFmSimilarArtistsJsonProvider.getResponse(artist.getArtistName(), limit);
		return new LastFmSimilarArtistsJsonMapper().collectionFromJson(artistsJson);
	}
}
