package com.kerrrusha.playlistassistant.controller;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.service.PlaylistProvider;
import com.kerrrusha.playlistassistant.viewmodel.SuitableTracksViewModel;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger(IndexServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(false);
		boolean loggedIn = (session != null && session.getAttribute("user") != null);

		if (loggedIn) {
			try {
				setSuitableTracksViewModel(session);
			} catch (DBException e) {
				logger.error(e);
				throw new RuntimeException(e);
			}
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void setSuitableTracksViewModel(HttpSession session) throws DBException {
		final User user = (User) session.getAttribute("user");
		final SuitableTracksViewModel viewModel = new SuitableTracksViewModel();
		final Collection<ItunesTrack> tracksFound;

		tracksFound = new PlaylistProvider().getUserPlaylist(user);
		logger.info("Found " + tracksFound.size() + " suitable track for user.id = " + user.getId());

		viewModel.setTracks(tracksFound);

		session.setAttribute("model", viewModel);
	}
}
