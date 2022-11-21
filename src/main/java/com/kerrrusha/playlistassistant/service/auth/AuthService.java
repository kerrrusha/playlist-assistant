package com.kerrrusha.playlistassistant.service.auth;

import com.kerrrusha.playlistassistant.model.User;

import javax.servlet.http.HttpServletRequest;

public class AuthService {

	private final HttpServletRequest request;

	public AuthService(HttpServletRequest request) {
		this.request = request;
	}

	public void authenticate(User user) {
		request.getSession().setAttribute("user", user);
	}

	public void signout() {
		request.getSession().invalidate();
	}
}
