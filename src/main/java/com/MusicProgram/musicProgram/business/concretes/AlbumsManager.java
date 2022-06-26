package com.MusicProgram.musicProgram.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MusicProgram.musicProgram.business.abstracts.AlbumsService;
import com.MusicProgram.musicProgram.dataAccess.abstracts.AlbumsDao;
import com.MusicProgram.musicProgram.entities.concretes.Albums;
import com.MusicProgram.musicProgram.exception.CustomNotFoundException;
import com.MusicProgram.musicProgram.exception.CustomNotNullException;
import com.MusicProgram.musicProgram.exception.InternalServerError;

@Service
public class AlbumsManager implements AlbumsService {

	private AlbumsDao albumsDao;

	@Autowired
	public AlbumsManager(AlbumsDao albumsDao) {
		super();
		this.albumsDao = albumsDao;
	}

	@Override
	public Albums add(Albums albums) {
		String album = albums.getAlbumName();
		if (album.isBlank() || album.isEmpty()) {
			throw new CustomNotNullException("Not Null");
		} else {
			return this.albumsDao.save(albums);
		}
	}

	@Override
	@Cacheable(cacheNames = "albums")
	public List<Albums> getAll() {
		return this.albumsDao.findAll();
	}

	@Override
	@Cacheable(cacheNames = "albums")
	public List<Albums> getByAlbumNameContains(String albumName) {

		if (albumsDao.getByAlbumNameContains(albumName).isEmpty()) {
			throw new InternalServerError("Not Found " + albumName);
		} else {
			return this.albumsDao.getByAlbumNameContains(albumName);
		}

	}

	@Override
	public Albums update(int id, Albums albums) {
		Optional<Albums> optionalAlbum = albumsDao.findById(id);

		if (optionalAlbum.isPresent()) {

			optionalAlbum.get().setMusic(albums.getMusic());
			optionalAlbum.get().setAlbumName(albums.getAlbumName());
			optionalAlbum.get().setSingerName(albums.getSingerName());

			if (albums.getAlbumName().isBlank() || albums.getAlbumName().isEmpty()) {
				throw new CustomNotNullException("Not Null");
			} else {
				return this.albumsDao.save(albums);
			}

		} else {
			throw new CustomNotFoundException("Not Found Id: " + id);
		}

	}

	@Override
	@Cacheable(cacheNames = "albums")
	public List<Albums> getAllPageAble(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return this.albumsDao.findAll(pageable).getContent();
	}

	@Override
	@Cacheable(cacheNames = "albums")
	public List<Albums> getByAlbumName(String albumName) {

		if (albumsDao.getByAlbumName(albumName).isEmpty()) {
			throw new InternalServerError("Not Found " + albumName);
		} else {
			return this.albumsDao.getByAlbumName(albumName);
		}

	}

	@Override
	@CacheEvict(cacheNames = "albums")
	public void delete(int id) {
		Optional<Albums> album = albumsDao.findById(id);
		if (album.isPresent()) {
			this.albumsDao.deleteById(id);
		} else {
			throw new CustomNotFoundException("Not Found");
		}

	}

}
