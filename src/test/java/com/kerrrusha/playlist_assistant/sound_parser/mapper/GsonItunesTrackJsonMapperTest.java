package com.kerrrusha.playlist_assistant.sound_parser.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class GsonItunesTrackJsonMapperTest {

	@Test
	public void testJsonToSong() throws IOException, URISyntaxException {
		Gson mapper = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.create();
		ItunesTrack expectedTrack = prepareTrack();
		ItunesTrack actualTrack = mapper.fromJson(getTrackJson(), ItunesTrack.class);

		assertEquals(expectedTrack, actualTrack);
	}

	private String getTrackJson() throws IOException, URISyntaxException {
		return new String(readResource("track/itunesTrackExample.json"), StandardCharsets.UTF_8);
	}

	private byte[] readResource(String resourcePath) throws IOException, URISyntaxException {
		URL url = getClass().getClassLoader().getResource(resourcePath);
		assert url != null;
		Path path = Paths.get(url.toURI());
		return Files.readAllBytes(path);
	}

	private ItunesTrack prepareTrack() {
		ItunesTrack song = new ItunesTrack();

		song.setTrackId(1012720714);
		song.setArtistId(883718129);
		song.setCollectionId(1012720709);
		song.setArtistName("Lullaby Baby Trio");
		song.setCollectionName("Lullaby Renditions of Metallica");
		song.setTrackName("Enter Sandman");
		song.setArtistViewUrl("https://music.apple.com/us/artist/lullaby-baby-trio/883718129?uo=4");
		song.setCollectionViewUrl("https://music.apple.com/us/album/enter-sandman/1012720709?i=1012720714&uo=4");
		song.setTrackViewUrl("https://music.apple.com/us/album/enter-sandman/1012720709?i=1012720714&uo=4");
		song.setPreviewUrl("https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview125/v4/b0/4f/4f/b04f4f6c-a7a1-47c8-50ba-90b17443bdcb/mzaf_13584377733722759354.plus.aac.p.m4a");
		song.setArtworkUrl100("https://is3-ssl.mzstatic.com/image/thumb/Music7/v4/e2/bf/73/e2bf73ff-fea4-2b9f-c067-a8f2768425bf/859715045956_cover.jpg/100x100bb.jpg");
		song.setReleaseDate(createDate());
		song.setCountry("USA");
		song.setPrimaryGenreName("Children's Music");

		return song;
	}

	private Date createDate() {
		String dateString = "2015-06-22";

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(dateString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
