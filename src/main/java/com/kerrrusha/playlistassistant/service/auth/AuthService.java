package com.kerrrusha.playlistassistant.service.auth;

import javax.servlet.http.HttpServletRequest;

public class AuthService {

	private final HttpServletRequest request;

	public AuthService(HttpServletRequest request) {
		this.request = request;
	}

	public void authenticate(int userId) {
		request.getSession().setAttribute("uid", userId);
	}

	public void signout() {
		request.getSession().invalidate();
	}
}
