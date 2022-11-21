package com.kerrrusha.playlistassistant.controller.user;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class SetFavouriteArtistsServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger(SetFavouriteArtistsServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		final Collection<String> selectedArtists = JsonParser.parseString(request.getParameter("selected-artists"))
				.getAsJsonArray().asList().stream()
				.map(JsonElement::toString)
				.collect(toSet());
		logger.info(selectedArtists);
	}
}
