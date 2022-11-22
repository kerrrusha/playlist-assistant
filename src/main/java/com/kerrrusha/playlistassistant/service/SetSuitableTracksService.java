package com.kerrrusha.playlistassistant.service;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user_suitable_track.UserSuitableTrackDao;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.model.UserSuitableTrack;
import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class SetSuitableTracksService {

	private final Collection<ItunesTrack> tracks;

	public SetSuitableTracksService(Collection<ItunesTrack> tracks) {
		this.tracks = tracks;
	}

	public void setToUser(User user) throws DBException {
		final Collection<UserSuitableTrack> entities = tracks.stream()
				.map(track -> mapToUserSuitableTrack(track, user))
				.collect(toSet());
		final UserSuitableTrackDao dao = new UserSuitableTrackDao();

		dao.deleteByUserId(user.getId());
		for(UserSuitableTrack entity : entities) {
			dao.insert(entity);
		}
	}

	private UserSuitableTrack mapToUserSuitableTrack(ItunesTrack track, User user) {
		final UserSuitableTrack entity = new UserSuitableTrack();

		entity.setUserId(user.getId());
		entity.setArtistName(track.getArtistName());
		entity.setTrackName(track.getTrackName());
		entity.setTrackPhotoUrl(track.getArtworkUrl100());

		return entity;
	}
}
