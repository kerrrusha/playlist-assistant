package com.kerrrusha.playlistassistant.service.auth;

import com.kerrrusha.playlistassistant.service.auth.result.AuthResult;
import com.kerrrusha.playlistassistant.validator.AbstractValidator;
import com.kerrrusha.playlistassistant.validator.auth.LoginValidator;
import org.apache.http.HttpStatus;

import java.util.Collection;

public class LoginService {

	private static final int OK_STATUS = HttpStatus.SC_OK;
	private static final int ERROR_STATUS = HttpStatus.SC_CONFLICT;

	private final String login;
	private final String password;

	public LoginService(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public AuthResult doLogin() {
		AuthResult result = new AuthResult();
		AbstractValidator validator = new LoginValidator(login, password);

		Collection<String> errorPool = validator.getErrors();
		if (!errorPool.isEmpty()) {
			result.setErrorPool(errorPool);
			result.setStatus(ERROR_STATUS);
			return result;
		}

		result.setStatus(OK_STATUS);
		return result;
	}
}
