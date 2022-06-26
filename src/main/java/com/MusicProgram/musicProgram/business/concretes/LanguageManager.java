package com.MusicProgram.musicProgram.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.MusicProgram.musicProgram.business.abstracts.LanguageService;
import com.MusicProgram.musicProgram.dataAccess.abstracts.LanguageDao;
import com.MusicProgram.musicProgram.entities.concretes.MusicLanguage;
import com.MusicProgram.musicProgram.entities.dto.Music_LanguageDto;
import com.MusicProgram.musicProgram.exception.CustomNotFoundException;
import com.MusicProgram.musicProgram.exception.CustomNotNullException;
import com.MusicProgram.musicProgram.exception.InternalServerError;

@Service
public class LanguageManager implements LanguageService {

	@Autowired
	private LanguageDao languageDao;

	@Override
	public List<Music_LanguageDto> getByMusicAndLanguage(String languageName) {

		if (languageDao.getByMusicAndLanguage(languageName).isEmpty()) {
			throw new InternalServerError("Not Found " + languageName + " language");
		} else {
			return this.languageDao.getByMusicAndLanguage(languageName);
		}

	}

	@Override
	public MusicLanguage add(MusicLanguage musicLanguage) {

		if (musicLanguage.getMusicLanguage().isBlank() || musicLanguage.getMusicLanguage().isEmpty()) {
			throw new InternalServerError("Not Null");
		} else {
			return this.languageDao.save(musicLanguage);
		}

	}

	@Override
	@Cacheable(cacheNames = "languages")
	public List<MusicLanguage> getAllLanguage() {
		return this.languageDao.findAll();
	}

	@Override
	@Cacheable(cacheNames = "languages")
	public List<MusicLanguage> getByMusicLanguageContains(String musicLanguage) {

		if (languageDao.getByMusicLanguageContains(musicLanguage).isEmpty()) {
			throw new InternalServerError("Not Found Anything");
		} else {
			return this.languageDao.getByMusicLanguageContains(musicLanguage);
		}

	}

	@Override
	@CacheEvict(cacheNames = "languages")
	public void deleteById(int id) {
		Optional<MusicLanguage> musicLanguage = languageDao.findById(id);

		if (musicLanguage.isPresent()) {
			this.languageDao.deleteById(id);
		} else {
			throw new NotFoundException("Not Found " + id);
		}

	}

	@Override
	public MusicLanguage update(int id, MusicLanguage musicLanguage) {
		Optional<MusicLanguage> optionalMusicLanguage = languageDao.findById(id);

		if (optionalMusicLanguage.isPresent()) {

			optionalMusicLanguage.get().setMusicLanguage(musicLanguage.getMusicLanguage());

			if (musicLanguage.getMusicLanguage().isBlank() || musicLanguage.getMusicLanguage().isEmpty()) {
				throw new CustomNotNullException("Not Null");
			} else {
				return this.languageDao.save(musicLanguage);
			}

		} else {
			throw new CustomNotFoundException("Not Found Id: " + id);
		}
	}

	@Override
	@Cacheable(cacheNames = "languages")
	public List<MusicLanguage> getAllPageable(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return this.languageDao.findAll(pageable).getContent();
	}

}
