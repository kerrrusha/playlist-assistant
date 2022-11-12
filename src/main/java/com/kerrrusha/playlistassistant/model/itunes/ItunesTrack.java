package com.kerrrusha.playlistassistant.model.itunes;

import com.kerrrusha.playlistassistant.model.AbstractTrack;

import java.util.Date;

public class ItunesTrack extends AbstractTrack {

	private int artistId;
	private int collectionId;
	private int trackId;
	private String collectionName;
	private String artistViewUrl, collectionViewUrl, trackViewUrl, previewUrl, artworkUrl100;
	private Date releaseDate;
	private String country, primaryGenreName;

	public ItunesTrack() {}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public int getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public int getTrackId() {
		return trackId;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getArtistViewUrl() {
		return artistViewUrl;
	}

	public void setArtistViewUrl(String artistViewUrl) {
		this.artistViewUrl = artistViewUrl;
	}

	public String getCollectionViewUrl() {
		return collectionViewUrl;
	}

	public void setCollectionViewUrl(String collectionViewUrl) {
		this.collectionViewUrl = collectionViewUrl;
	}

	public String getTrackViewUrl() {
		return trackViewUrl;
	}

	public void setTrackViewUrl(String trackViewUrl) {
		this.trackViewUrl = trackViewUrl;
	}

	public String getPreviewUrl() {
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	public String getArtworkUrl100() {
		return artworkUrl100;
	}

	public void setArtworkUrl100(String artworkUrl100) {
		this.artworkUrl100 = artworkUrl100;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPrimaryGenreName() {
		return primaryGenreName;
	}

	public void setPrimaryGenreName(String primaryGenreName) {
		this.primaryGenreName = primaryGenreName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ItunesTrack other = (ItunesTrack) o;

		return getTrackId() == other.getTrackId() &&
				getArtistId() == other.getArtistId() &&
				getCollectionId() == other.getCollectionId() &&
				getArtistName().equals(other.getArtistName()) &&
				getCollectionName().equals(other.getCollectionName()) &&
				getTrackName().equals(other.getTrackName()) &&
				getArtistViewUrl().equals(other.getArtistViewUrl()) &&
				getCollectionViewUrl().equals(other.getCollectionViewUrl()) &&
				getTrackViewUrl().equals(other.getTrackViewUrl()) &&
				getPreviewUrl().equals(other.getPreviewUrl()) &&
				getArtworkUrl100().equals(other.getArtworkUrl100()) &&
				getReleaseDate().equals(other.getReleaseDate()) &&
				getCountry().equals(other.getCountry()) &&
				getPrimaryGenreName().equals(other.getPrimaryGenreName());
	}

	@Override
	public String toString() {
		return String.format("ItunesSong [\n" +
				"artistId = %s\n" +
				"collectionId = %s\n" +
				"trackId = %s\n" +
				"artistName = %s\n" +
				"collectionName = %s\n" +
				"trackName = %s\n" +
				"artistViewUrl = %s\n" +
				"collectionViewUrl = %s\n" +
				"trackViewUrl = %s\n" +
				"previewUrl = %s\n" +
				"artworkUrl100 = %s\n" +
				"releaseDate = %s\n" +
				"country = %s\n" +
				"primaryGenreName = %s\n" +
				"]",
				getArtistId(),
				getCollectionId(),
				getTrackId(),
				getArtistName(),
				getCollectionName(),
				getTrackName(),
				getArtistViewUrl(),
				getCollectionViewUrl(),
				getTrackViewUrl(),
				getPreviewUrl(),
				getArtworkUrl100(),
				getReleaseDate(),
				getCountry(),
				getPrimaryGenreName());
	}
}
