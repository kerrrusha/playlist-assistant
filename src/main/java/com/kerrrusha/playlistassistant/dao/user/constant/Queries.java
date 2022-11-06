package com.kerrrusha.playlistassistant.dao.user.constant;

public class Queries {

	public static final String SELECT_ALL_USERS = "SELECT * FROM \"user\"";

	public static final String INSERT_USER = "INSERT INTO \"user\"(login, password) VALUES (?, ?)";

	public static final String FIND_USER_BY_ID = "SELECT * FROM \"user\" WHERE id = ?";
	public static final String FIND_USER_BY_LOGIN = "SELECT * FROM \"user\" WHERE login = ?";

	public static final String DELETE_USER_BY_ID = "DELETE FROM \"user\" where id = ?";
	public static final String DELETE_USER_BY_LOGIN = "DELETE FROM \"user\" where login = ?";
}
