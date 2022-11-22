package com.kerrrusha.playlistassistant.service.auth;

import com.google.gson.Gson;
import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.service.auth.result.AuthResult;
import org.apache.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static com.kerrrusha.playlistassistant.util.ServletUtil.setJsonToResponse;

public class AuthResultSender extends AuthResult {

	private final Gson gson = new Gson();

	public static AuthResultSender valueOf(AuthResult anotherResult) {
		AuthResultSender sender = new AuthResultSender();

		sender.setStatus(anotherResult.getStatus());
		sender.setErrorPool(anotherResult.getErrorPool());
		sender.setUser(anotherResult.getUser());

		return sender;
	}

	public void sendResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			new AuthService(request).authenticate(getUser());
		} catch (DBException e) {
			setErrorPool(Collections.singleton(e.getMessage()));
			setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		}

		setJsonToResponse(response, gson.toJson(this));
		response.getWriter().flush();
	}
}
