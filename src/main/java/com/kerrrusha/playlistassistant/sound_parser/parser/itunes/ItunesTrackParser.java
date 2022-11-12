package com.kerrrusha.playlistassistant.sound_parser.parser.itunes;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.sound_parser.http_gate.UrlBuilder;
import com.kerrrusha.playlistassistant.sound_parser.mapper.itunes.ItunesTrackJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.parser.itunes.constant.ItunesMediaValues;
import com.kerrrusha.playlistassistant.sound_parser.parser.itunes.constant.ItunesParameterKeys;
import com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.prepareTerm;
import static com.kerrrusha.playlistassistant.util.SubstringUtil.substringBetween;
import static java.util.stream.Collectors.toSet;

public class ItunesTrackParser {

	static final String BASE_URL = "https://itunes.apple.com/search";

	public Collection<ItunesTrack> getTracksByTerm(String term) throws IOException {
		term = prepareTerm(term);

		String responseJson = getResponseJsonStringFromTerm(term);
		final ItunesTrackJsonMapper mapper = new ItunesTrackJsonMapper();
		return Arrays.stream(jsonToElements(responseJson))
				.map(mapper::fromJson)
				.collect(toSet());
	}

	private String getResponseJsonStringFromTerm(String term) throws IOException {
		UrlBuilder builder = new UrlBuilder(BASE_URL);
		builder.addParameter(ItunesParameterKeys.TERM, term);
		builder.addParameter(ItunesParameterKeys.MEDIA, ItunesMediaValues.MUSIC);
		return HttpGetterUtil.getResponseString(builder.build());
	}

	public static String[] jsonToElements(String json) {
		String rawJson = json.replaceAll("},", "}");
		String onlyElements = substringBetween(rawJson, ": [", "]\n}");
		return onlyElements.split("(?<=})");
	}
}
