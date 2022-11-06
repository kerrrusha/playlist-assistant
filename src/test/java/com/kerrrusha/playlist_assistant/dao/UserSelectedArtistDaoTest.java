package com.kerrrusha.playlist_assistant.dao;

import com.kerrrusha.playlistassistant.dao.user_selected_artist.UserSelectedArtistDao;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserSelectedArtistDaoTest {

	@Test
	public void isConnectedTest() {
		assertDoesNotThrow(UserSelectedArtistDao::new);
	}
}
