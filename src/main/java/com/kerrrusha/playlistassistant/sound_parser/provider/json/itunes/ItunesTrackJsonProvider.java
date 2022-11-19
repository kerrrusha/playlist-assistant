package com.kerrrusha.playlistassistant.sound_parser.provider.json.itunes;

import com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil;
import com.kerrrusha.playlistassistant.sound_parser.http_gate.UrlBuilder;
import com.kerrrusha.playlistassistant.sound_parser.parser.itunes.constant.ItunesMediaValues;
import com.kerrrusha.playlistassistant.sound_parser.parser.itunes.constant.ItunesParameterKeys;

import java.io.IOException;

public class ItunesTrackJsonProvider {

	static final String BASE_URL = "https://itunes.apple.com/search";

	public static String getResponse(String term) throws IOException {
		UrlBuilder builder = new UrlBuilder(BASE_URL);
		builder.addParameter(ItunesParameterKeys.TERM, term);
		builder.addParameter(ItunesParameterKeys.MEDIA, ItunesMediaValues.MUSIC);
		return HttpGetterUtil.getResponseString(builder.build());
	}

	public static String getResponse(String term, int limit) throws IOException {
		UrlBuilder builder = new UrlBuilder(BASE_URL);
		builder.addParameter(ItunesParameterKeys.TERM, term);
		builder.addParameter(ItunesParameterKeys.MEDIA, ItunesMediaValues.MUSIC);
		builder.addParameter(ItunesParameterKeys.LIMIT, ""+limit);
		return HttpGetterUtil.getResponseString(builder.build());
	}
}
