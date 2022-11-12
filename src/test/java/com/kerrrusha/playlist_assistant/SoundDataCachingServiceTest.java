package com.kerrrusha.playlist_assistant;

import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataCachingService;
import org.junit.Test;

import java.io.IOException;

public class SoundDataCachingServiceTest {

	@Test
	public void testNotThrows() {
		try {
			new SoundDataCachingService().requestAll();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
