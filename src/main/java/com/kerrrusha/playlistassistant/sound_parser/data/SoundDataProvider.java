package com.kerrrusha.playlistassistant.sound_parser.data;

import com.kerrrusha.playlistassistant.sound_parser.data.cache.SoundDataCache;
import com.kerrrusha.playlistassistant.sound_parser.data.cache.SoundDataCacheLoader;
import org.apache.log4j.Logger;

public class SoundDataProvider extends SoundDataCache {

	private static final Logger logger = Logger.getLogger(SoundDataProvider.class);
	private static SoundDataProvider instance;

	private SoundDataProvider() {
		setValues(SoundDataCacheLoader.load());
		doPostprocess();
		logger.info(getClass().getSimpleName() + " is fully initialized and ready for use.");
	}

	private void doPostprocess() {
		logger.info("Postprocess was started.");
		final int removedEmptyValues = removeEmptyValues();
		logger.info("Postprocess was finished. Was removed " + removedEmptyValues + " empty values.");
	}

	public static SoundDataProvider getInstance() {
		if (instance == null) {
			instance = new SoundDataProvider();
		}
		return instance;
	}
}
