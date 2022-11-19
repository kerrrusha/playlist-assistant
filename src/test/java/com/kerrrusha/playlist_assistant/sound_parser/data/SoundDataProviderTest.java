package com.kerrrusha.playlist_assistant.sound_parser.data;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataProvider;
import org.junit.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SoundDataProviderTest {

	@Test
	public void assertTopGenresAreCollected() {
		Collection<LastFmGenre> topGenres = SoundDataProvider.getInstance().getTopGenres();
		System.out.println("Collected " + topGenres.size() + " elements");
		assertTrue(topGenres.size() > 0);
	}

	@Test
	public void assertTopGenreArtistsAreCollected() {
		Collection<LastFmArtist> topGenreArtists = SoundDataProvider.getInstance().getTopGenreArtists();
		System.out.println("Collected " + topGenreArtists.size() + " elements");
		assertTrue(topGenreArtists.size() > 0);
	}

	@Test
	public void assertSimilarArtistsTopTracksAreCollected() {
		Collection<ItunesTrack> similarArtistsTopTracks = SoundDataProvider.getInstance().getSimilarArtistsTopTracks();
		System.out.println("Collected " + similarArtistsTopTracks.size() + " elements");
		assertTrue(similarArtistsTopTracks.size() > 0);
	}
}
