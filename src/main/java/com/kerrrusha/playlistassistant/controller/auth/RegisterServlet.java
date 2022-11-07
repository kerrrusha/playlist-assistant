package com.kerrrusha.playlistassistant.controller.auth;

import com.google.gson.Gson;
import com.kerrrusha.playlistassistant.service.auth.AuthService;
import com.kerrrusha.playlistassistant.service.auth.RegisterService;
import com.kerrrusha.playlistassistant.service.auth.result.AuthResult;

import javax.servlet.http.*;
import java.io.IOException;

import static com.kerrrusha.playlistassistant.util.ServletUtil.setJsonToResponse;

public class RegisterServlet extends HttpServlet {

	private final Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String login = request.getParameter("login");
		final String password = request.getParameter("password");
		final String passwordRepeat = request.getParameter("passwordRepeat");

		AuthResult result = new RegisterService(login, password, passwordRepeat).processRegister();
		new AuthService(request).authenticate(result.getUserId());

		setJsonToResponse(response, gson.toJson(result));

		response.getWriter().flush();
	}
}
