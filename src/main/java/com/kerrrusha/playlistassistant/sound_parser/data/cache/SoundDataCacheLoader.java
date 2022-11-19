package com.kerrrusha.playlistassistant.sound_parser.data.cache;

import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataImportingService;
import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataReader;

public class SoundDataCacheLoader extends SoundDataCache {

	final static SoundDataReader reader = new SoundDataReader();

	public static SoundDataCache load() {
		if (!reader.dataFilesIsOk()) {
			new SoundDataImportingService().importAll();
		}

		final SoundDataCache cache = new SoundDataCache();

		cache.setTopGenres(reader.readTopGenres());
		cache.setTopGenreArtists(reader.readTopGenreArtists());
		cache.setPresentableTopGenreArtists(reader.readPresentableTopGenreArtists());
		cache.setSimilarArtistsTopTracks(reader.readSimilarArtistsTopTracks());

		return cache;
	}
}
