package com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm;

import com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil;

import java.io.IOException;

public class LastFmTrackJsonProvider {

	static final String API_KEY = "70375b3e1e3f4a5ed7f433270af4e3a2";
	static final String FIND_TRACK_URL = String.format("https://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key=%s&format=json", API_KEY);

	public static String getResponse(String trackId) {
		String url = FIND_TRACK_URL + "&mbid=" + trackId;
		try {
			return HttpGetterUtil.getResponseString(url);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
