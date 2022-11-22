package com.kerrrusha.playlistassistant.service;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.model.presentable.PresentableArtist;
import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataProvider;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class PlaylistAssistantService {

	protected final SoundDataProvider provider;

	public PlaylistAssistantService() {
		provider = SoundDataProvider.getInstance();
	}

	public Collection<ItunesTrack> generatePlaylist(Collection<PresentableArtist> selectedArtists) {
		return selectedArtists.stream()
				.map(this::getSimilarArtists)
				.filter(elem -> !elem.isEmpty())
				.flatMap(Collection::stream)
				.map(this::getTopTracks)
				.flatMap(Collection::stream)
				.collect(toSet());
	}

	private Collection<LastFmArtist> getSimilarArtists(PresentableArtist artist) {
		return provider.getTopGenreArtists().stream()
				.filter(lastFmArtist -> lastFmArtist.getArtistName().equalsIgnoreCase(artist.getArtistName()))
				.map(LastFmArtist::getSimilar)
				.flatMap(Collection::stream)
				.collect(toSet());
	}

	private Collection<ItunesTrack> getTopTracks(LastFmArtist artist) {
		return provider.getSimilarArtistsTopTracks().stream()
				.filter(track -> track.getArtistName().equalsIgnoreCase(artist.getArtistName()))
				.collect(toSet());
	}
}
