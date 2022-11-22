package com.kerrrusha.playlistassistant.dao.user_suitable_track;

import com.kerrrusha.playlistassistant.dao.AbstractDao;
import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user_suitable_track.constant.*;
import com.kerrrusha.playlistassistant.model.UserSuitableTrack;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserSuitableTrackDao extends AbstractDao {

	public UserSuitableTrackDao() throws DBException {}

	public Collection<UserSuitableTrack> findAll() throws DBException {
		Collection<UserSuitableTrack> entities = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     Statement stmt = con.createStatement();
		     ResultSet rs = stmt.executeQuery(Queries.SELECT_ALL_USER_SUITABLE_TRACKS)) {
			while(rs.next()) {
				entities.add(mapToUserSuitableTrack(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return entities;
	}

	public Collection<UserSuitableTrack> findAllByUserId(int userId) throws DBException {
		Collection<UserSuitableTrack> entities = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.FIND_USER_SUITABLE_TRACK_BY_USER_ID)) {
			stmt.setInt(1, userId);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					entities.add(mapToUserSuitableTrack(rs));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return entities;
	}

	public void insert(UserSuitableTrack entity) throws DBException {
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.INSERT_USER_SUITABLE_TRACK)) {
			stmt.setInt(1, entity.getUserId());
			stmt.setString(2, entity.getArtistName());
			stmt.setString(3, entity.getTrackName());
			stmt.setString(4, entity.getTrackPhotoUrl());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
	}

	public void deleteById(UserSuitableTrack entity) throws DBException {
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.DELETE_USER_SUITABLE_TRACK_BY_ID)) {
			stmt.setInt(1, entity.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
	}

	public void deleteByUserId(int userId) throws DBException {
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.DELETE_USER_SUITABLE_TRACK_BY_USER_ID)) {
			stmt.setInt(1, userId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
	}

	private UserSuitableTrack mapToUserSuitableTrack(ResultSet rs) throws SQLException {
		UserSuitableTrack entity = new UserSuitableTrack();

		entity.setId(rs.getInt(Fields.USER_SUITABLE_TRACK_ID));
		entity.setUserId(rs.getInt(Fields.USER_SUITABLE_TRACK_USER_ID));
		entity.setArtistName(rs.getString(Fields.USER_SUITABLE_TRACK_ARTIST_NAME));
		entity.setTrackName(rs.getString(Fields.USER_SUITABLE_TRACK_TRACK_NAME));
		entity.setTrackPhotoUrl(rs.getString(Fields.USER_SUITABLE_TRACK_TRACK_PHOTO_URL));

		return entity;
	}
}
