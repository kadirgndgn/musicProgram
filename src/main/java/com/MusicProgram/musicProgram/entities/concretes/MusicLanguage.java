package com.MusicProgram.musicProgram.entities.concretes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class MusicLanguage implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "music_language_id")
	private int musicLanguageId;

	@Column(name = "music_language")
	private String musicLanguage;

	@OneToMany(mappedBy = "musicLanguage")
	private List<Music> musics;

	public MusicLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MusicLanguage(int musicLanguageId, String musicLanguage) {
		super();
		this.musicLanguageId = musicLanguageId;
		this.musicLanguage = musicLanguage;
	}

	public int getMusicLanguageId() {
		return musicLanguageId;
	}

	public void setMusicLanguageId(int musicLanguageId) {
		this.musicLanguageId = musicLanguageId;
	}

	public String getMusicLanguage() {
		return musicLanguage;
	}

	public void setMusicLanguage(String musicLanguage) {
		this.musicLanguage = musicLanguage;
	}

}
