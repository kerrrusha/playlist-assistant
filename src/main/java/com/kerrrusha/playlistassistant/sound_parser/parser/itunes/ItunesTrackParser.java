package com.kerrrusha.playlistassistant.sound_parser.parser.itunes;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.sound_parser.mapper.itunes.ItunesTrackJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.itunes.ItunesTrackJsonProvider;

import java.io.IOException;
import java.util.Collection;

public class ItunesTrackParser {

	public Collection<ItunesTrack> getTracksByTerm(String term) throws IOException {
		String responseJson = ItunesTrackJsonProvider.getResponse(term);
		return new ItunesTrackJsonMapper().collectionFromJson(responseJson);
	}
}
