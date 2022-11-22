package com.kerrrusha.playlistassistant.controller;

import com.kerrrusha.playlistassistant.sound_parser.data.SoundDataProvider;
import com.kerrrusha.playlistassistant.viewmodel.SetFavouriteArtistsViewModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectFavouriteArtistsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		SetFavouriteArtistsViewModel viewModel = new SetFavouriteArtistsViewModel();

		viewModel.setArtists(SoundDataProvider.getInstance().getPresentableTopGenreArtists().shuffle());

		request.setAttribute("model", viewModel);
		request.getRequestDispatcher("select-favourite-artists.jsp").forward(request, response);
	}
}
