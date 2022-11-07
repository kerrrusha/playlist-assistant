package com.kerrrusha.playlistassistant.util;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user.UserDao;

public class DaoUtil {

	public static int getUserId(String login) {
		try {
			return new UserDao().findOneByLogin(login).getId();
		} catch (DBException e) {
			throw new RuntimeException(e);
		}
	}
}
