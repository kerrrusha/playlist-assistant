package com.kerrrusha.playlist_assistant;

import com.kerrrusha.playlistassistant.sound_parser.http_gate.UrlBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlBuilderTest {

	@Test
	public void testEmptyCase() {
		UrlBuilder builder = new UrlBuilder();
		assertEquals("", builder.build());
	}

	@Test
	public void testNoUrlSingleParameterCase() {
		final String key = "testKey";
		final String value = "testValue";
		final String expected = "?testKey=testValue";

		UrlBuilder builder = new UrlBuilder();
		builder.addParameter(key, value);
		assertEquals(expected, builder.build());
	}

	@Test
	public void testUrlNoParametersCase() {
		final String url = "google.com";
		final String expected = "google.com";

		UrlBuilder builder = new UrlBuilder(url);
		assertEquals(expected, builder.build());
	}

	@Test
	public void testUrlSingleParameterCase() {
		final String key = "testKey";
		final String value = "testValue";
		final String url = "google.com";
		final String expected = "google.com?testKey=testValue";

		UrlBuilder builder = new UrlBuilder(url);
		builder.addParameter(key, value);
		assertEquals(expected, builder.build());
	}

	@Test
	public void testUrlTwoParameterCase() {
		final String url = "google.com";
		final String expected = "google.com?key1=value1&key2=value2";

		UrlBuilder builder = new UrlBuilder(url);
		builder.addParameter("key1", "value1");
		builder.addParameter("key2", "value2");
		assertEquals(expected, builder.build());
	}
}
