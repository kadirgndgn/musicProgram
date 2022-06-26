package com.MusicProgram.musicProgram.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MusicProgram.musicProgram.entities.concretes.MyList;

public interface MyListDao extends JpaRepository<MyList, Integer> {

	@Query("From MyList where musicName=:musicName")
	List<MyList> getByMusicName(String musicName);

	List<MyList> getByMusicNameStartsWith(String musicName);

	List<MyList> getByMusicNameContains(String musicName);

}
