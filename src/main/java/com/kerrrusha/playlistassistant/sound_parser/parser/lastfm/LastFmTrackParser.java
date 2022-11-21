package com.kerrrusha.playlistassistant.sound_parser.parser.lastfm;

import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmTrack;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmTrackJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm.LastFmGenreTopTracksProvider;

import java.io.IOException;
import java.util.Collection;

public class LastFmTrackParser {

	public Collection<LastFmTrack> getTopTracks(LastFmGenre genre, int limit) throws IOException {
		String genreTracksJson = LastFmGenreTopTracksProvider.getResponse(genre.getName(), limit);
		return new LastFmTrackJsonMapper().collectionFromJson(genreTracksJson);
	}
}
