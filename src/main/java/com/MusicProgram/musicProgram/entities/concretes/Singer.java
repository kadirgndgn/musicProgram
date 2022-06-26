package com.MusicProgram.musicProgram.entities.concretes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "singers")
public class Singer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "singer_id")
	private int singerId;

	@Column(name = "singer_name")
	private String singerName;

	@OneToMany(mappedBy = "singer")
	private List<Music> musics;

	@JoinColumn(name = "myList_id")
	@ManyToOne()
	private MyList myList;

	public Singer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Singer(int singerId, String singerName) {
		super();
		this.singerId = singerId;
		this.singerName = singerName;
	}

	public int getSingerId() {
		return singerId;
	}

	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

}
