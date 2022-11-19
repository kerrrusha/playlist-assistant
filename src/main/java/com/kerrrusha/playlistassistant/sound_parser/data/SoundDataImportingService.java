package com.kerrrusha.playlistassistant.sound_parser.data;

import com.kerrrusha.playlistassistant.factory.genre.GenreFactory;
import com.kerrrusha.playlistassistant.model.AbstractArtist;
import com.kerrrusha.playlistassistant.model.AbstractGenre;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.sound_parser.data.constant.SoundDataPaths;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmTopGenreJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmTopArtistsJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.itunes.ItunesTrackJsonProvider;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm.LastFmArtistJsonProvider;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm.LastFmGenreTopArtistsJsonProvider;
import com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm.LastFmTopGenreJsonProvider;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.substringBetween;

public class SoundDataImportingService {

	private static final Logger logger = Logger.getLogger(SoundDataImportingService.class);

	private static final int TOP_GENRES_LIMIT = 20;
	private static final int GENRE_TOP_ARTISTS_LIMIT = 3;
	private static final int SIMILAR_ARTISTS_TOP_TRACKS_LIMIT = 3;

	public void importAll() {
		try {
			final String genresJson = getTopGenresJson();
			saveToFile(SoundDataPaths.TOP_GENRES_PATH, genresJson);

			final Collection<String> topArtistsJson = getGenreTopArtistsJson(mapToGenres(genresJson));
			final Collection<String> lastFmTopArtistsJson = mapToLastFmArtistsJson(topArtistsJson);
			saveToFile(SoundDataPaths.TOP_GENRE_ARTISTS_PATH, lastFmTopArtistsJson.stream().collect(joining(System.lineSeparator())));

			final Collection<AbstractArtist> similarArtists = mapToSimilarArtists(mapToLastFmArtists(topArtistsJson));

			final Collection<String> topTracksJson = getTopTracksJson(similarArtists);
			saveToFile(SoundDataPaths.SIMILAR_ARTISTS_TOP_TRACKS_PATH, topTracksJson.stream().collect(joining(System.lineSeparator())));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	private Collection<String> mapToLastFmArtistsJson(Collection<String> topArtistsJson) {
		return topArtistsJson.stream()
				.map(json -> substringBetween(json, "\"mbid\":\"", "\""))
				.map(LastFmArtistJsonProvider::getResponse)
				.collect(toSet());
	}

	private Collection<AbstractArtist> mapToSimilarArtists(Collection<LastFmArtist> lastFmArtists) {
		return lastFmArtists.stream()
				.map(LastFmArtist::getSimilar)
				.flatMap(Collection::stream)
				.collect(toSet());
	}

	private Collection<LastFmArtist> mapToLastFmArtists(Collection<String> topArtistsJson) {
		final LastFmTopArtistsJsonMapper mapper = new LastFmTopArtistsJsonMapper();
		return topArtistsJson.stream()
				.map(mapper::collectionFromJson)
				.flatMap(Collection::stream)
				.collect(toSet());
	}

	private Collection<AbstractGenre> mapToGenres(String jsonGenres) {
		return new LastFmTopGenreJsonMapper().collectionFromJson(jsonGenres).stream()
				.limit(TOP_GENRES_LIMIT)
				.map(lastFmGenre -> GenreFactory.createGenre(lastFmGenre.getName()))
				.collect(toSet());
	}

	private String getTopGenresJson() throws IOException {
		return LastFmTopGenreJsonProvider.getResponse();
	}

	private Collection<String> getGenreTopArtistsJson(Collection<AbstractGenre> genres) {
		return genres.stream()
				.map(genre -> {
					try {
						return LastFmGenreTopArtistsJsonProvider.getResponse(genre.getName(), GENRE_TOP_ARTISTS_LIMIT);
					} catch (IOException e) {
						logger.error(e.getMessage());
						return EMPTY;
					}
				})
				.collect(toSet());
	}

	private Collection<String> getTopTracksJson(Collection<AbstractArtist> artists) {
		return artists.stream().
				map(artist -> {
					try {
						return ItunesTrackJsonProvider.getResponse(artist.getArtistName(), SIMILAR_ARTISTS_TOP_TRACKS_LIMIT);
					} catch (IOException e) {
						logger.error(e.getMessage());
						return EMPTY;
					}
				})
				.collect(toSet());
	}

	private void saveToFile(String filename, String data) throws IOException {
		Files.write(Paths.get(filename), data.getBytes());
	}
}
