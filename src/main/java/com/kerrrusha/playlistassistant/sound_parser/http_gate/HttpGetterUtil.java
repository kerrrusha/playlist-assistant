package com.kerrrusha.playlistassistant.sound_parser.http_gate;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpGetterUtil {

	private HttpGetterUtil() {}

	public static String getResponseString(String url) throws IOException {
		HttpGet request = new HttpGet(url);
		try (CloseableHttpClient client = HttpClients.createDefault();
		     CloseableHttpResponse response = client.execute(request)) {
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		}
	}

	public static String prepareTerm(String term)  {
		return term.replaceAll(" ", "+");
	}
}
