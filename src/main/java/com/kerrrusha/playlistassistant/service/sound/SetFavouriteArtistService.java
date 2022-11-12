package com.kerrrusha.playlistassistant.service.sound;

import com.kerrrusha.playlistassistant.factory.artist.PresentableArtistFactory;
import com.kerrrusha.playlistassistant.model.AbstractArtist;
import com.kerrrusha.playlistassistant.model.AbstractGenre;
import com.kerrrusha.playlistassistant.model.deezer.DeezerArtist;
import com.kerrrusha.playlistassistant.model.presentable.PresentableArtist;
import com.kerrrusha.playlistassistant.sound_parser.parser.deezer.DeezerArtistParser;
import com.kerrrusha.playlistassistant.sound_parser.parser.lastfm.LastFmGenreTopArtistsParser;
import com.kerrrusha.playlistassistant.sound_parser.parser.lastfm.LastFmTopGenreParser;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import static java.util.stream.Collectors.toSet;

public class SetFavouriteArtistService {

	private static final int ARTISTS_PER_GENRE = 3;

	private final int uid;
	private final LastFmGenreTopArtistsParser lastFmGenreTopArtistsParser;
	private final DeezerArtistParser deezerArtistParser;

	public SetFavouriteArtistService(int uid) {
		this.uid = uid;
		lastFmGenreTopArtistsParser = new LastFmGenreTopArtistsParser();
		deezerArtistParser = new DeezerArtistParser();
	}

	public Collection<PresentableArtist> getTopArtists(int limit) throws IOException {
		final int GENRES_COUNT = limit / ARTISTS_PER_GENRE;

		return getTopGenres(GENRES_COUNT).stream()
				.map(this::mapGenreToAbstractArtists)
				.flatMap(Collection::stream)
				.map(this::mapToPresentableArtist)
				.collect(toSet());
	}

	private Collection<AbstractArtist> mapGenreToAbstractArtists(AbstractGenre genre) {
		int currentAttempt = 0;
		final int MAX_ATTEMPTS = 3;
		while (currentAttempt < MAX_ATTEMPTS) {
			try {
				return lastFmGenreTopArtistsParser.getTopArtists(genre).stream().limit(ARTISTS_PER_GENRE).collect(toSet());
			} catch (IOException e) {
				e.printStackTrace();
				++currentAttempt;
				System.out.println("Attempt " + currentAttempt + "/" + MAX_ATTEMPTS);
			}
		}
		return new HashSet<>();
	}

	private PresentableArtist mapToPresentableArtist(AbstractArtist artist) {
		DeezerArtist deezerArtist;
		try {
			deezerArtist = deezerArtistParser.getArtist(artist.getArtistName());
		} catch (IOException e) {
			return PresentableArtistFactory.createEmpty();
		}
		return PresentableArtistFactory.createArtist(deezerArtist);
	}

	private Collection<AbstractGenre> getTopGenres(int limit) throws IOException {
		return new LastFmTopGenreParser().getTopGenres().stream().limit(limit).collect(toSet());
	}
}
