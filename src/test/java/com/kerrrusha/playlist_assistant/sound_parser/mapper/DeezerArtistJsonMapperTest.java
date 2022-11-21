package com.kerrrusha.playlist_assistant.sound_parser.mapper;

import com.kerrrusha.playlistassistant.model.deezer.DeezerArtist;
import com.kerrrusha.playlistassistant.sound_parser.mapper.deezer.DeezerArtistJsonMapper;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeezerArtistJsonMapperTest {

	private static final String INCORRECT_JSON = "{\"error\":{\"type\":\"InvalidQueryException\",\"message\":\"Unknown path components : \\/artist\\/AC\\/DC\",\"code\":600}}";

	@Test
	public void incorrectJsonTest() {
		DeezerArtist artist = new DeezerArtistJsonMapper().fromJson(INCORRECT_JSON);
		assertNotNull(artist);
	}
}
