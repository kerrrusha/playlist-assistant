package com.kerrrusha.playlistassistant.sound_parser.data;

import com.kerrrusha.playlistassistant.sound_parser.data.cache.SoundDataCache;
import com.kerrrusha.playlistassistant.sound_parser.data.cache.SoundDataCacheLoader;

public class SoundDataProvider extends SoundDataCache {

	private static SoundDataProvider instance;

	private SoundDataProvider() {
		copyValues(SoundDataCacheLoader.load());
	}

	public static SoundDataProvider getInstance() {
		if (instance == null) {
			instance = new SoundDataProvider();
		}
		return instance;
	}
}
