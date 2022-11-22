package com.kerrrusha.playlistassistant.service.auth;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user.UserDao;
import com.kerrrusha.playlistassistant.model.User;

import javax.servlet.http.HttpServletRequest;

public class AuthService {

	private final HttpServletRequest request;

	public AuthService(HttpServletRequest request) {
		this.request = request;
	}

	public void authenticate(User user) throws DBException {
		request.getSession().setAttribute("user", new UserDao().findOneByLogin(user.getLogin()));
	}

	public void signout() {
		request.getSession().invalidate();
	}
}
