package com.MusicProgram.musicProgram.entities.concretes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Albums implements Serializable{

	@Id
	
	private int id;
	private String singerName;
	private String albumName;
	private List<Music> music;

	public Albums() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Albums(int id, String singerName, String albumName, List<Music> music) {
		super();
		this.id = id;
		this.singerName = singerName;
		this.albumName = albumName;
		this.music = music;
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

	public List<Music> getMusic() {
		return music;
	}

	public void setMusic(List<Music> music) {
		this.music = music;
	}

}
