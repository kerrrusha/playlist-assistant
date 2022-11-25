package com.kerrrusha.playlistassistant.controller.user;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.model.presentable.PresentableArtist;
import com.kerrrusha.playlistassistant.service.PlaylistAssistantService;
import com.kerrrusha.playlistassistant.service.SetFavouriteArtistsService;
import com.kerrrusha.playlistassistant.service.SetSuitableTracksService;
import com.kerrrusha.playlistassistant.util.SetFavouriteArtistsUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class SetFavouriteArtistsServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger(SetFavouriteArtistsServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		final User user = (User)request.getSession().getAttribute("user");
		final Collection<PresentableArtist> selectedArtists = SetFavouriteArtistsUtil.
				mapJsonToPresentableArtists(request.getParameter("selected-artists"));
		logger.info("User has selected "+selectedArtists.size()+" artists.");

		try {
			new SetFavouriteArtistsService(selectedArtists).setToUser(user);
		} catch (DBException e) {
			logger.error(e);
			throw new RuntimeException(e);
		}

		final Collection<ItunesTrack> suitableTracks = new PlaylistAssistantService().generatePlaylist(selectedArtists);
		logger.info("Generated " + suitableTracks.size() + " tracks for user.id = " + user.getId());
		try {
			new SetSuitableTracksService(suitableTracks).setToUser(user);
		} catch (DBException e) {
			logger.error(e);
			throw new RuntimeException(e);
		}
	}
}
