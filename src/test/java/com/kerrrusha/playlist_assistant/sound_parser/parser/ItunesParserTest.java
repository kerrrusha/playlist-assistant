package com.kerrrusha.playlist_assistant.sound_parser.parser;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.sound_parser.parser.itunes.ItunesTrackParser;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class ItunesParserTest {

	@Test
	public void getItunesTrackTest() throws IOException {
		ItunesTrack track = new ItunesTrackParser().getTracksByTerm("Master of Puppets").stream()
				.limit(1)
				.findFirst().orElse(null);
		System.out.println(track);
		assertNotNull(track);
	}
}
