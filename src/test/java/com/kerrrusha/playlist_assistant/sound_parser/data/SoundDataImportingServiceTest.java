package com.kerrrusha.playlist_assistant.sound_parser.data;

import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataImportingService;
import org.junit.Test;

public class SoundDataImportingServiceTest {

	@Test
	public void testNotThrows() {
		new SoundDataImportingService().importAll();
	}
}
