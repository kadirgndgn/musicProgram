package com.MusicProgram.musicProgram.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MusicProgram.musicProgram.business.abstracts.MusicService;
import com.MusicProgram.musicProgram.dataAccess.abstracts.MusicDao;
import com.MusicProgram.musicProgram.entities.concretes.Music;
import com.MusicProgram.musicProgram.entities.dto.MusicCategoryDto;
import com.MusicProgram.musicProgram.entities.dto.Music_LanguageDto;
import com.MusicProgram.musicProgram.entities.dto.Music_SingerDto;
import com.MusicProgram.musicProgram.entities.dto.Music_Singer_CategoryDto;
import com.MusicProgram.musicProgram.exception.CustomNotFoundException;
import com.MusicProgram.musicProgram.exception.CustomNotNullException;

@Service
public class MusicManager implements MusicService {

	private MusicDao musicDao;

	@Autowired
	public MusicManager(MusicDao musicDao) {
		super();
		this.musicDao = musicDao;
	}

	@Override
	public Music add(Music music) {
		return this.musicDao.save(music);
	}

	@Override
	@Cacheable(cacheNames = "music")
	public List<Music> getAll() {
		return this.musicDao.findAll();
	}

	@Override
	@Cacheable(cacheNames = "music")
	public List<MusicCategoryDto> getByMusicAndCategory(String musicName) {

		if (musicDao.getByMusicAndCategory(musicName).isEmpty()) {
			throw new CustomNotFoundException("Not Found " + musicName);
		} else {
			return this.musicDao.getByMusicAndCategory(musicName);
		}

	}

	@Override
	@Cacheable(cacheNames = "music")
	public List<Music> getAllPageable(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return this.musicDao.findAll(pageable).getContent();

	}

	@Override
	@Cacheable(cacheNames = "music")
	public List<Music> getByMusicNameContains(String musicName) {

		if (musicDao.getByMusicNameContains(musicName).isEmpty()) {
			throw new CustomNotFoundException("Not Found " + musicName + " in your values");
		} else {
			return this.musicDao.getByMusicNameContains(musicName);
		}

	}

	@Override
	@Cacheable(cacheNames = "music")
	public List<Music> getByMusicNameStartsWith(String musicName) {

		if (musicDao.getByMusicNameStartsWith(musicName).isEmpty()) {
			throw new CustomNotFoundException("Not Found Startswith " + musicName);
		} else {
			return this.musicDao.getByMusicNameStartsWith(musicName);
		}

	}

	@Override
	@CacheEvict(cacheNames = "music")
	public void deleteById(int id) {
		Optional<Music> music = musicDao.findById(id);

		if (music.isPresent()) {
			this.musicDao.deleteById(id);
		} else {
			throw new CustomNotFoundException("Not Found Id: " + id);
		}

	}

	@Override
	public Music update(int id, Music music) {
		Optional<Music> optionalSing = musicDao.findById(id);

		if (optionalSing.isPresent()) {

			optionalSing.get().setMusicName(music.getMusicName());
			optionalSing.get().setMusicLyrics(music.getMusicLyrics());

			if (music.getMusicName().isBlank() || music.getMusicName().isEmpty()) {
				throw new CustomNotNullException("Not Null");
			} else {
				return this.musicDao.save(music);
			}

		} else {
			throw new CustomNotFoundException("Not Found");
		}

	}

	@Override
	@Cacheable(cacheNames = "music")
	public List<Music_LanguageDto> getByMusicAndLanguage() {
		return this.musicDao.getByMusicAndLanguage();
	}

	@Override
	public List<Music_SingerDto> getByMusicAndSinger(String musicName) {

		if (musicDao.getByMusicAndSinger(musicName).isEmpty()) {
			throw new CustomNotFoundException("Not Found " + musicName);
		} else {
			return this.musicDao.getByMusicAndSinger(musicName);
		}

	}

	@Override
	@Cacheable(cacheNames = "music")
	public List<Music_Singer_CategoryDto> getByMusicSingerCategory(String musicName) {

		if (musicDao.getByMusicSingerCategory(musicName).isEmpty()) {
			throw new CustomNotFoundException("Not Found");
		} else {
			return this.musicDao.getByMusicSingerCategory(musicName);
		}

	}

	@Override
	@Cacheable(cacheNames = "music")
	public List<Music_SingerDto> getByMusicNameAndSingerName() {
		return this.musicDao.getByMusicNameAndSingerName();
	}

}
