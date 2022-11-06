package com.kerrrusha.playlistassistant.validator.auth;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user.UserDao;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.validator.Validator;

import java.util.Optional;

public class RegisterValidator extends Validator {

	private static final String INCORRECT_LOGIN = "Login must be at least 3 characters long and must not contain spaces.";
	private static final String INCORRECT_PASSWORD = "Password must be at least 3 characters long and must not contain spaces.";
	private static final String DATABASE_ERROR = "Something is wrong with the server. We will definitely fix this, but for now, please try again.";
	private static final String LOGIN_ALREADY_EXISTS = "Such login already exists.";
	private static final String PASSWORDS_DO_NOT_MATCHES = "Passwords don't match.";

	private final String login;
	private final String password;
	private final String passwordRepeat;

	public RegisterValidator(String login, String password, String passwordRepeat) {
		this.login = login;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
	}

	@Override
	protected void validate() {
		addPossibleError(validateLogin());
		addPossibleError(validatePasswords());
		addPossibleError(validateIfExists());
	}

	private Optional<String> validateLogin() {
		return (login.length() < 3 || login.contains(" ")) ? Optional.of(INCORRECT_LOGIN) : Optional.empty();
	}

	private Optional<String> validatePasswords() {
		if ((password.length() < 3 || password.contains(" ") || passwordRepeat.length() < 3 || passwordRepeat.contains(" "))) {
			return Optional.of(INCORRECT_PASSWORD);
		}
		return password.equals(passwordRepeat) ? Optional.empty() : Optional.of(PASSWORDS_DO_NOT_MATCHES);
	}

	private Optional<String> validateIfExists() {
		User user;

		try {
			user = new UserDao().findOneByLogin(login);
		} catch (DBException e) {
			return Optional.of(DATABASE_ERROR);
		}

		return user.isEmpty() ? Optional.empty() : Optional.of(LOGIN_ALREADY_EXISTS);
	}
}
