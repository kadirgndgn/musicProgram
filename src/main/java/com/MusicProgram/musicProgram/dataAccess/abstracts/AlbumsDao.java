package com.MusicProgram.musicProgram.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.MusicProgram.musicProgram.entities.concretes.Albums;

public interface AlbumsDao extends MongoRepository<Albums, Integer> {

	@Query("From Albums as a where a.id=:id and a.albumName=:albumName")
	List<Albums> getByAlbumsNameWithId(int id, String albumName);

	List<Albums> getByAlbumName(String albumName);

	List<Albums> getByAlbumNameContains(String albumName);

}
