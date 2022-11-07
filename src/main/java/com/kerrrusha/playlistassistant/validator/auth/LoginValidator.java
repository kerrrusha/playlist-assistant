package com.kerrrusha.playlistassistant.validator.auth;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user.UserDao;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.validator.AbstractValidator;

import java.util.Collection;
import java.util.Optional;

import static com.kerrrusha.playlistassistant.util.ValidatorUtil.checkIfFieldIsNull;

public class LoginValidator extends AbstractValidator {

	private static final String DATABASE_ERROR = "Something is wrong with the server. We will definitely fix this, but for now, please try again.";
	private static final String INVALID_LOGIN = "Such login does not exists.";
	private static final String INVALID_PASSWORD = "Password is invalid.";
	private static final String LOGIN_IS_NULL = "Something is wrong while submitting login to the server. We will definitely fix this, but for now, please try again.";
	private static final String PASSWORD_IS_NULL = "Something is wrong while submitting password to the server. We will definitely fix this, but for now, please try again.";

	private final String login;
	private final String password;

	public LoginValidator(String login, String password) {
		this.login = login;
		this.password = password;
	}

	@Override
	protected void validate() {
		addPossibleError(checkIfFieldIsNull(login, LOGIN_IS_NULL));
		addPossibleError(checkIfFieldIsNull(password, PASSWORD_IS_NULL));
		addPossibleError(validateUser());
	}

	@Override
	public Collection<String> getErrors() {
		clearPossibleErrors();
		validate();
		return getErrorPool();
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
		return user == null ? Optional.of(INVALID_LOGIN) : Optional.empty();
	}

	private Optional<String> validatePassword(User user) {
		return user.getPassword().equals(password) ? Optional.empty() : Optional.of(INVALID_PASSWORD);
	}
}
