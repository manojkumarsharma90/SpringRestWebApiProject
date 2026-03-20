package com.cg.entity;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="abes_track")
@DynamicUpdate
public class Track {
	
	@Id
	@Column(name="track_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer trackId;
	
	@Column(name="track_title",length=45)
	String trackTitle;
	
	@Column(name="album_name",nullable=false)
	String albumName;
	
	@Column(name="release_date")
	LocalDate releaseDate;
	
	public Integer getTrackId() {
		return trackId;
	}
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}
	public String getTrackTitle() {
		return trackTitle;
	}
	public void setTrackTitle(String trackitle) {
		this.trackTitle = trackitle;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "Track [trackId=" + trackId + ", trackitle=" + trackTitle + ", albumName=" + albumName + ", releaseDate="
				+ releaseDate + "]";
	}
	
	
	
	

}
