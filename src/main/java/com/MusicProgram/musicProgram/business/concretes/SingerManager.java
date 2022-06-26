package com.MusicProgram.musicProgram.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MusicProgram.musicProgram.business.abstracts.SingerService;
import com.MusicProgram.musicProgram.dataAccess.abstracts.SingerDao;
import com.MusicProgram.musicProgram.entities.concretes.Singer;
import com.MusicProgram.musicProgram.entities.dto.Music_SingerDto;
import com.MusicProgram.musicProgram.exception.CustomNotFoundException;
import com.MusicProgram.musicProgram.exception.CustomNotNullException;

@Service
public class SingerManager implements SingerService {

	@Autowired
	private SingerDao singerDao;

	@Override
	public List<Music_SingerDto> getByMusicAndSinger(String singerName) {

		if (singerDao.getByMusicAndSinger(singerName).isEmpty()) {
			throw new CustomNotFoundException("Not Found " + singerName + "'s musics");
		} else {
			return this.singerDao.getByMusicAndSinger(singerName);
		}

	}

	@Override
	@Cacheable(cacheNames = "singer")
	public List<Singer> getAll() {
		Optional<List<Singer>> singer = Optional.empty();
		if (singer.isPresent()) {
			throw new CustomNotFoundException("Not Found Singer");
		} else {
			return this.singerDao.findAll();
		}

	}

	@Override
	public Singer add(Singer singer) {

		if (singer.getSingerName().isBlank() || singer.getSingerName().isEmpty()) {
			throw new CustomNotFoundException("Not Null SingerName");
		} else {
			return this.singerDao.save(singer);
		}

	}

	@Override
	public Singer update(int id, Singer singer) {
		Optional<Singer> optionalSinger = singerDao.findById(id);

		if (optionalSinger.isPresent()) {

			optionalSinger.get().setSingerName(singer.getSingerName());

			if (singer.getSingerName().isBlank() || singer.getSingerName().isEmpty()) {
				throw new CustomNotNullException("Not Null");
			} else {
				return this.singerDao.save(singer);
			}

		} else {
			throw new CustomNotFoundException("Not Found Id: " + id);
		}

	}

	@Override
	@CacheEvict(cacheNames = "singer")
	public void delete(int id) {
		Optional<Singer> number = singerDao.findById(id);
		if (number.isPresent()) {
			singerDao.deleteById(id);
		} else {
			throw new CustomNotFoundException("Not Found Id " + id);
		}

	}

	@Override
	@Cacheable(cacheNames = "singer")
	public List<Singer> getAllPageAble(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return this.singerDao.findAll(pageable).getContent();

	}

	@Override
	@Cacheable(cacheNames = "singer")
	public List<Singer> getBySingerNameContains(String singerName) {

		if (singerDao.getBySingerNameContains(singerName).isEmpty()) {
			throw new CustomNotFoundException("Not Found this words " + singerName + " in your values");
		} else {
			return this.singerDao.getBySingerNameContains(singerName);
		}

	}

	@Override
	@Cacheable(cacheNames = "singer")
	public List<Singer> getBySingerNameStartsWith(String singerName) {

		if (singerDao.getBySingerNameStartsWith(singerName).isEmpty()) {
			throw new CustomNotFoundException("Not Found Started this word " + singerName + " in your values.");
		} else {
			return this.singerDao.getBySingerNameStartsWith(singerName);
		}

	}

	@Override
	@Cacheable(cacheNames = "singer")
	public List<Singer> getBySingerName(String singerName) {

		if (singerDao.getBySingerName(singerName).isEmpty()) {
			throw new CustomNotFoundException("Not Found " + singerName);
		} else {
			return this.singerDao.getBySingerName(singerName);
		}

	}

}