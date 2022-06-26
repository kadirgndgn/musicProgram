package com.MusicProgram.musicProgram.entities.dto;

public class SingerAlbumsDto {

	private int id;
	private String singerName;
	private String albumName;

	public SingerAlbumsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SingerAlbumsDto(int id, String singerName, String albumName) {
		super();
		this.id = id;
		this.singerName = singerName;
		this.albumName = albumName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

}