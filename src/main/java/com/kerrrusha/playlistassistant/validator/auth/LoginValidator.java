package com.kerrrusha.playlistassistant.validator.auth;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user.UserDao;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.validator.Validator;

import java.util.Optional;

public class LoginValidator extends Validator {

	private static final String DATABASE_ERROR = "Something is wrong with the server. We will definitely fix this, but for now, please try again.";
	private static final String INVALID_LOGIN = "Such login does not exists.";
	private static final String INVALID_PASSWORD = "Password is invalid.";

	private final String login;
	private final String password;

	public LoginValidator(String login, String password) {
		this.login = login;
		this.password = password;
	}

	@Override
	protected void validate() {
		addPossibleError(validateUser());
	}

	private Optional<String> validateUser() {
		User user;

		try {
			user = new UserDao().findOneByLogin(login);
		} catch (DBException e) {
			return Optional.of(DATABASE_ERROR);
		}

		Optional<String> loginPossibleError = validateLogin(user);

		return loginPossibleError.isPresent() ? loginPossibleError : validatePassword(user);
	}

	private Optional<String> validateLogin(User user) {
		return user.isEmpty() ? Optional.of(INVALID_LOGIN) : Optional.empty();
	}

	private Optional<String> validatePassword(User user) {
		return user.getPassword().equals(password) ? Optional.empty() : Optional.of(INVALID_PASSWORD);
	}
}
