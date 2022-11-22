package com.kerrrusha.playlistassistant.service;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user_suitable_track.UserSuitableTrackDao;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.model.UserSuitableTrack;
import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class PlaylistProvider extends PlaylistAssistantService {

	public Collection<ItunesTrack> getUserPlaylist(User user) throws DBException {
		return new UserSuitableTrackDao().findAllByUserId(user.getId()).stream()
				.map(this::mapToItunesTrack)
				.collect(toSet());
	}

	private ItunesTrack mapToItunesTrack(UserSuitableTrack entity) {
		final ItunesTrack track = new ItunesTrack();

		track.setArtistName(entity.getArtistName());
		track.setTrackName(entity.getTrackName());
		track.setArtworkUrl100(entity.getTrackPhotoUrl());

		return tryToFillItunesTrack(track);
	}

	private ItunesTrack tryToFillItunesTrack(ItunesTrack track) {
		return provider.getSimilarArtistsTopTracks().stream()
				.filter(providerTrack ->
						providerTrack.getArtistName().equalsIgnoreCase(track.getArtistName()) &&
						providerTrack.getTrackName().equalsIgnoreCase(track.getTrackName()))
				.findFirst().orElse(track);
	}
}
