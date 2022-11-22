package com.kerrrusha.playlistassistant.dao.user_selected_artist.constant;

public class Queries {

	public static final String SELECT_ALL_USER_SELECTED_ARTISTS = "SELECT * FROM \"user_selected_artist\"";

	public static final String INSERT_USER_SELECTED_ARTIST = "INSERT INTO \"user_selected_artist\"(user_id, artist_name, artist_photo_url)" +
			" VALUES (?, ?, ?)";

	public static final String FIND_USER_SELECTED_ARTIST_BY_USER_ID = "SELECT * FROM \"user_selected_artist\" WHERE user_id = ?";

	public static final String DELETE_USER_SELECTED_ARTIST_BY_ID = "DELETE FROM \"user_selected_artist\" WHERE id = ?";

	public static final String DELETE_USER_SELECTED_ARTIST_BY_USER_ID = "DELETE FROM \"user_selected_artist\" WHERE user_id = ?";
}
