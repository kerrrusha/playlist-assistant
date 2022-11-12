package com.kerrrusha.playlist_assistant.sound_parser.parser;

import com.kerrrusha.playlistassistant.factory.genre.LastFmGenreFactory;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmTrack;
import com.kerrrusha.playlistassistant.sound_parser.parser.lastfm.LastFmGenreTopArtistsParser;
import com.kerrrusha.playlistassistant.sound_parser.parser.lastfm.LastFmTopGenreParser;
import com.kerrrusha.playlistassistant.sound_parser.parser.lastfm.LastFmTrackParser;
import org.junit.Test;

import java.io.IOException;

import static com.kerrrusha.playlistassistant.factory.genre.GenreFactory.createGenre;
import static org.junit.Assert.assertNotNull;

public class LastFmParserTest {

	@Test
	public void getLastFmTopArtistsTest() throws IOException {
		LastFmArtist artist = new LastFmGenreTopArtistsParser().getTopArtists(createGenre("metal")).stream()
				.limit(1)
				.findFirst().orElse(null);
		System.out.println(artist);
		assertNotNull(artist);
	}

	@Test
	public void getLastFmTopGenreTest() throws IOException {
		LastFmGenre genre = new LastFmTopGenreParser().getTopGenres().stream()
				.limit(1)
				.findFirst().orElse(null);
		System.out.println(genre);
		assertNotNull(genre);
	}

	@Test
	public void getLastFmGenreTopTrackTest() throws IOException {
		LastFmTrack track = new LastFmTrackParser().getTopTracks(LastFmGenreFactory.createGenre("metal"), 1)
				.stream()
				.findFirst().orElse(null);
		System.out.println(track);
		assertNotNull(track);
	}
}
