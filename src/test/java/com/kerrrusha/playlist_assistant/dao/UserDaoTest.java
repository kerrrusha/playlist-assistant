package com.kerrrusha.playlist_assistant.dao;

import com.kerrrusha.playlistassistant.dao.user.UserDao;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserDaoTest {

	@Test
	public void isConnectedAndGetsUserTableTest() {
		UserDao dao = new UserDao();

		assertDoesNotThrow(dao::findAll);
	}
}
