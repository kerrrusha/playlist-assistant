package com.kerrrusha.playlistassistant.sound_parser.data;

import com.kerrrusha.playlistassistant.factory.genre.GenreFactory;
import com.kerrrusha.playlistassistant.model.AbstractArtist;
import com.kerrrusha.playlistassistant.model.AbstractGenre;
import com.kerrrusha.playlistassistant.sound_parser.data.constant.SoundDataPaths;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmArtistJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmGenreJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.provider.itunes.ItunesTrackJsonProvider;
import com.kerrrusha.playlistassistant.sound_parser.provider.lastfm.LastFmGenreTopArtistsJsonProvider;
import com.kerrrusha.playlistassistant.sound_parser.provider.lastfm.LastFmTopGenreJsonProvider;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class SoundDataCachingService {

	private static final Logger logger = Logger.getLogger(SoundDataCachingService.class);

	public void requestAll() throws IOException {
		final String jsonGenres = requestTopGenres();
		final Collection<AbstractGenre> genres = new LastFmGenreJsonMapper().collectionFromJson(jsonGenres).stream()
				.limit(20)
				.map(lastFmGenre -> GenreFactory.createGenre(lastFmGenre.getName()))
				.collect(toSet());

		final Collection<AbstractArtist> artists = requestTopGenreArtists(genres);

		requestTopGenreArtistsTracks(artists);
	}

	private String requestTopGenres() throws IOException {
		final String json = LastFmTopGenreJsonProvider.getResponse();
		saveToFile(SoundDataPaths.TOP_GENRES, json);
		return json;
	}

	private Collection<AbstractArtist> requestTopGenreArtists(Collection<AbstractGenre> genres) throws IOException {
		final Collection<String> jsonResponses = genres.stream()
				.map(genre -> {
					try {
						return LastFmGenreTopArtistsJsonProvider.getResponse(genre.getName(), 3);
					} catch (IOException e) {
						logger.error(e.getMessage());
						return EMPTY;
					}
				})
				.collect(toSet());

		final LastFmArtistJsonMapper mapper = new LastFmArtistJsonMapper();
		final Collection<AbstractArtist> artists = jsonResponses.stream()
				.map(mapper::collectionFromJson)
				.flatMap(Collection::stream)
				.collect(toSet());

		final String json = jsonResponses.stream()
						.collect(joining(System.lineSeparator()));
		saveToFile(SoundDataPaths.TOP_GENRE_ARTISTS, json);

		return artists;
	}

	private void requestTopGenreArtistsTracks(Collection<AbstractArtist> artists) throws IOException {
		final String json = artists.stream().
				map(artist -> {
					try {
						return ItunesTrackJsonProvider.getResponse(artist.getArtistName(), 3);
					} catch (IOException e) {
						logger.error(e.getMessage());
						return EMPTY;
					}
				})
				.collect(joining(System.lineSeparator()));
		saveToFile(SoundDataPaths.TOP_GENRE_ARTISTS_TRACKS, json);
	}

	private void saveToFile(String filename, String data) throws IOException {
		Files.write(Paths.get(SoundDataPaths.BASE_PATH + filename), data.getBytes());
	}
}
