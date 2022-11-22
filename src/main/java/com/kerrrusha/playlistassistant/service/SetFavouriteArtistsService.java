package com.kerrrusha.playlistassistant.service;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user_selected_artist.UserSelectedArtistsDao;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.model.UserSelectedArtist;
import com.kerrrusha.playlistassistant.model.presentable.PresentableArtist;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class SetFavouriteArtistsService {

	private final Collection<PresentableArtist> artists;

	public SetFavouriteArtistsService(Collection<PresentableArtist> artists) {
		this.artists = artists;
	}

	public void setToUser(User user) throws DBException {
		final Collection<UserSelectedArtist> entities = artists.stream()
				.map(artist -> mapToUserSelectedArtist(artist, user))
				.collect(toSet());
		final UserSelectedArtistsDao dao = new UserSelectedArtistsDao();

		dao.deleteByUserId(user.getId());
		for(UserSelectedArtist entity : entities) {
			dao.insert(entity);
		}
	}

	private UserSelectedArtist mapToUserSelectedArtist(PresentableArtist artist, User user) {
		final UserSelectedArtist entity = new UserSelectedArtist();

		entity.setUserId(user.getId());
		entity.setArtistName(artist.getArtistName());
		entity.setArtistPhotoUrl(artist.getPhotoUrl());

		return entity;
	}
}
