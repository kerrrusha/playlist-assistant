package com.kerrrusha.playlistassistant.controller.auth;

import com.google.gson.Gson;
import com.kerrrusha.playlistassistant.service.auth.AuthService;
import com.kerrrusha.playlistassistant.service.auth.LoginService;
import com.kerrrusha.playlistassistant.service.auth.result.AuthResult;

import javax.servlet.http.*;
import java.io.IOException;

import static com.kerrrusha.playlistassistant.util.ServletUtil.setJsonToResponse;

public class LoginServlet extends HttpServlet {

	private final Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String login = request.getParameter("login");
		final String password = request.getParameter("password");

		AuthResult result = new LoginService(login, password).processLogin();
		new AuthService(request).authenticate(result.getUserId());

		setJsonToResponse(response, gson.toJson(result));

		response.getWriter().flush();
	}
}
