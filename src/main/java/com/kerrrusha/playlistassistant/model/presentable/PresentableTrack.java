package com.kerrrusha.playlistassistant.model.presentable;

import com.kerrrusha.playlistassistant.model.AbstractTrack;

public class PresentableTrack extends AbstractTrack {

	protected String photoUrl;

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "PresentableTrack{" +
				"photoUrl='" + photoUrl + '\'' +
				", trackName='" + trackName + '\'' +
				", artistName='" + artistName + '\'' +
				'}';
	}
}
