package com.kerrrusha.playlistassistant.dao.user_suitable_track.constant;

public class Queries {

	public static final String SELECT_ALL_USER_SUITABLE_TRACKS = "SELECT * FROM \"user_suitable_track\"";

	public static final String INSERT_USER_SUITABLE_TRACK = "INSERT INTO \"user_suitable_track\"(user_id, " +
			"artist_name, track_name, track_photo_url) VALUES (?, ?, ?, ?)";

	public static final String FIND_USER_SUITABLE_TRACK_BY_USER_ID = "SELECT * FROM \"user_suitable_track\" " +
			"WHERE user_id = ?";

	public static final String DELETE_USER_SUITABLE_TRACK_BY_ID = "DELETE FROM \"user_suitable_track\" " +
			"WHERE id = ?";

	public static final String DELETE_USER_SUITABLE_TRACK_BY_USER_ID = "DELETE FROM \"user_suitable_track\" " +
			"WHERE user_id = ?";
}
