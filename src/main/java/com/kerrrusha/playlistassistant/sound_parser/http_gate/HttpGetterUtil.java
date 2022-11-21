package com.kerrrusha.playlistassistant.sound_parser.http_gate;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;

public class HttpGetterUtil {

	private static final Logger logger = Logger.getLogger(HttpGetterUtil.class);

	static {
		System.setProperty("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.NoOpLog");
	}

	private HttpGetterUtil() {}

	public static String getResponseString(String url) throws IOException {
		return getResponseString(url, "+");
	}

	public static String getResponseString(String url, String whitespace) throws IOException {
		url = prepareUrl(url, whitespace);
		logger.info("Request: " + url);
		HttpGet request = new HttpGet(url);
		int timeout = 5;
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(timeout * 1000)
				.setConnectionRequestTimeout(timeout * 1000)
				.setSocketTimeout(timeout * 1000).build();
		try (CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		     CloseableHttpResponse response = client.execute(request)) {
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		}
	}

	private static String prepareUrl(String query, String whitespace) {
		return query.replaceAll(" ", whitespace)
				.replaceAll("\\\\", "");
	}
}
