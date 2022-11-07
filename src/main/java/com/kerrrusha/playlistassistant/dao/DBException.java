package com.kerrrusha.playlistassistant.dao;

import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;

public class DBException extends SQLException {

	private final String message;

	public DBException() {
		message = StringUtils.EMPTY;
	}
	public DBException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
