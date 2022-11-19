package com.kerrrusha.playlistassistant.sound_parser.data;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.sound_parser.mapper.itunes.ItunesTrackJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmArtistJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmTopGenreJsonMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static com.kerrrusha.playlistassistant.sound_parser.data.constant.SoundDataPaths.*;
import static java.util.stream.Collectors.toSet;

public class SoundDataReader {

	private static final LastFmTopGenreJsonMapper topGenreMapper = new LastFmTopGenreJsonMapper();
	private static final LastFmArtistJsonMapper topGenreArtistsMapper = new LastFmArtistJsonMapper();
	private static final ItunesTrackJsonMapper similarArtistsTopTracksMapper = new ItunesTrackJsonMapper();

	public boolean dataFilesIsOk() {
		return Files.exists(Paths.get(TOP_GENRES_PATH))
				&& Files.exists(Paths.get(TOP_GENRE_ARTISTS_PATH))
				&& Files.exists(Paths.get(SIMILAR_ARTISTS_TOP_TRACKS_PATH));
	}

	public Collection<LastFmGenre> readTopGenres() {
		try {
			final String topGenresJson = new String(Files.readAllBytes(Paths.get(TOP_GENRES_PATH)),
					StandardCharsets.UTF_8);
			return topGenreMapper.collectionFromJson(topGenresJson);
		} catch (IOException e) {
			return new HashSet<>();
		}
	}

	public Collection<LastFmArtist> readTopGenreArtists() {
		try {
			final Collection<String> topGenreArtistsJson = Arrays.stream(new String(Files.readAllBytes(Paths.get(TOP_GENRE_ARTISTS_PATH)),
					StandardCharsets.UTF_8).split(System.lineSeparator()))
					.collect(toSet());
			return topGenreArtistsJson.stream()
					.map(topGenreArtistsMapper::fromJson)
					.collect(toSet());
		} catch (IOException e) {
			return new HashSet<>();
		}
	}

	public Collection<ItunesTrack> readSimilarArtistsTopTracks() {
		try {
			final Collection<String> similarArtistsTopTracksJson = Arrays.stream(new String(Files.readAllBytes(Paths.get(SIMILAR_ARTISTS_TOP_TRACKS_PATH)),
							StandardCharsets.UTF_8).split(System.lineSeparator()))
					.filter(str -> !str.isEmpty())
					.collect(toSet());
			return similarArtistsTopTracksJson.stream()
					.map(similarArtistsTopTracksMapper::collectionFromJson)
					.flatMap(Collection::stream)
					.collect(toSet());
		} catch (IOException e) {
			return new HashSet<>();
		}
	}
}
