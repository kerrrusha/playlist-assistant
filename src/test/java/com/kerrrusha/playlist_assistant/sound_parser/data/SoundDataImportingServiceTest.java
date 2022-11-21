package com.kerrrusha.playlist_assistant.sound_parser.data;

import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataImportingService;
import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataProvider;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.deezer.DeezerArtistJsonProvider;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("Disabled because takes a lot of time")
public class SoundDataImportingServiceTest {

	@Test
	public void testNotThrows() {
		new SoundDataImportingService().importAll();
	}

	@Test
	public void mapToPresentableArtistsJsonTest() {
		Collection<LastFmArtist> artists = SoundDataProvider.getInstance().getTopGenreArtists();
		Collection<String> presentableArtistsJson = artists.stream()
				.map(LastFmArtist::getArtistName)
				.map(String::toLowerCase)
				.map(DeezerArtistJsonProvider::getResponse)
				.collect(Collectors.toCollection(ArrayList::new));
		assertEquals(artists.size(), presentableArtistsJson.size());
	}
}
