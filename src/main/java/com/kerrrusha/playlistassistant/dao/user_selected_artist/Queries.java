package com.kerrrusha.playlistassistant.dao.user_selected_artist;

public class Queries {

	public static final String SELECT_ALL_USERS_SELECTED_ARTISTS = "SELECT * FROM user_selected_artist";

	public static final String INSERT_USER_SELECTED_ARTIST = "INSERT INTO user_selected_artist(user_id, artist_name) VALUES (?, ?)";

	public static final String FIND_USER_SELECTED_ARTISTS_BY_USER_ID = "SELECT * FROM user_selected_artist WHERE user_id = ?";

	public static final String DELETE_USER_SELECTED_ARTIST = "DELETE FROM user_selected_artist WHERE id = ?";
}
