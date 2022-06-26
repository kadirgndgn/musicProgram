package com.MusicProgram.musicProgram.entities.dto;

import java.io.Serializable;

public class CommentUserMusic implements Serializable {

	private String userName;
	private String musicName;
	private String comment;

	public CommentUserMusic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentUserMusic(String userName, String musicName, String comment) {
		super();
		this.userName = userName;
		this.musicName = musicName;
		this.comment = comment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}