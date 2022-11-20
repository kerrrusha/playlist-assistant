package com.kerrrusha.playlistassistant.sound_parser.data.cache;

import com.kerrrusha.playlistassistant.factory.data.SoundDataEntryFactory;
import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataImportingService;
import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataReader;
import org.apache.log4j.Logger;

public class SoundDataCacheLoader extends SoundDataCache {

	private static final Logger logger = Logger.getLogger(SoundDataCacheLoader.class);
	private static final SoundDataReader reader = new SoundDataReader();

	public static SoundDataCache load() {
		logger.info("Cache loading is started.");

		if (!reader.dataFilesIsOk()) {
			logger.info("Sound data files not exists/are corrupted. Re-importing is starting.");
			new SoundDataImportingService().importAll();
		}

		final SoundDataCache cache = new SoundDataCache();

		cache.setTopGenres(SoundDataEntryFactory.parse(reader.readTopGenres()));
		cache.setTopGenreArtists(SoundDataEntryFactory.parse(reader.readTopGenreArtists()));
		cache.setPresentableTopGenreArtists(SoundDataEntryFactory.parse(reader.readPresentableTopGenreArtists()));
		cache.setSimilarArtistsTopTracks(SoundDataEntryFactory.parse(reader.readSimilarArtistsTopTracks()));

		logger.info("Cache loading is finished. Cache contains:" + System.lineSeparator() + cache);

		return cache;
	}
}
