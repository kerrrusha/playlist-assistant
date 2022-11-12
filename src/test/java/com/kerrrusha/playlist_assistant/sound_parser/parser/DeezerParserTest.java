package com.kerrrusha.playlist_assistant.sound_parser.parser;

import com.kerrrusha.playlistassistant.model.deezer.DeezerArtist;
import com.kerrrusha.playlistassistant.sound_parser.parser.deezer.DeezerArtistParser;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class DeezerParserTest {

	@Test
	public void getDeezerArtistTest() throws IOException {
		DeezerArtist artist = new DeezerArtistParser().getArtist("metallica");
		System.out.println(artist);
		assertNotNull(artist);
	}
}
