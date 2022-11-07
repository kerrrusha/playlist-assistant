package com.kerrrusha.playlistassistant.sound_parser.http_gate;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UrlBuilder {

	private static final String SEPARATOR = "&";

	private final String BASE_URL;
	private final Map<String, String> keyValueParams;

	public UrlBuilder() {
		this("");
	}
	public UrlBuilder(String baseUrl) {
		keyValueParams = new HashMap<>();
		BASE_URL = baseUrl;
	}

	public void addParameter(String key, String value) {
		keyValueParams.put(key, value);
	}

	public String build() {
		if (keyValueParams.isEmpty()) {
			return BASE_URL;
		}
		return removeLastSeparator(BASE_URL + "?" + keyValueParams.keySet().stream()
				.map(key -> key + "=" + keyValueParams.get(key) + SEPARATOR)
				.collect(Collectors.joining()));
	}

	private String removeLastSeparator(String url) {
		int indexOfSeparator = url.lastIndexOf(SEPARATOR);
		return url.substring(0, indexOfSeparator) + url.substring(indexOfSeparator + 1);
	}
}
