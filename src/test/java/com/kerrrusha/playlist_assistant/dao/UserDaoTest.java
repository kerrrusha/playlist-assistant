package com.kerrrusha.playlist_assistant.dao;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user.UserDao;
import com.kerrrusha.playlistassistant.model.User;
import org.junit.Test;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

	@Test
	public void isConnectedTest() {
		assertDoesNotThrow(UserDao::new);
	}

	@Test
	public void insertDeleteTest() {
		try {
			final UserDao dao = new UserDao();

			final String login = "UserDaoTestLogin";
			final String password = "UserDaoTestPassword";
			final User user = new User();

			user.setLogin(login);
			user.setPassword(password);

			dao.deleteByLogin(user);
			dao.insert(user);

			User userFromDb = dao.findOneByLogin(login);

			assertEquals(login, userFromDb.getLogin());
			assertEquals(password, userFromDb.getPassword());

			dao.deleteByLogin(user);

			assertNull(dao.findOneByLogin(login));

		} catch (DBException e) {
			throw new RuntimeException();
		}
	}

	@Test
	public void findAllTest() {
		try {
			final UserDao dao = new UserDao();

			String select = dao.findAll().stream().map(User::toString).collect(joining());
			System.out.println(select);

			assertFalse(select.isEmpty());

		} catch (DBException e) {
			throw new RuntimeException();
		}
	}
}
