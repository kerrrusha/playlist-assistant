package com.kerrrusha.playlist_assistant.sound_parser.provider;

import com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm.LastFmArtistJsonProvider;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm.LastFmGenreTopArtistsJsonProvider;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LastFmJsonProviderTest {

	@Test
	public void genreTopArtistsLimitTest() throws IOException {
		final String genreName = "rock";
		final int limit = 3;
		String response = LastFmGenreTopArtistsJsonProvider.getResponse(genreName, limit);
		System.out.println(response);
		assertTrue(response.length() > 0);
	}

	@Test
	public void artistTest() {
		final String acdcMbid = "66c662b6-6e2f-4930-8610-912e24c63ed1";
		String response = LastFmArtistJsonProvider.getResponse(acdcMbid);
		System.out.println(response);
		assertTrue(response.length() > 0);
	}
}
