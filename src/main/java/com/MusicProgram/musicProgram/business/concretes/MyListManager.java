package com.MusicProgram.musicProgram.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MusicProgram.musicProgram.business.abstracts.MyListService;
import com.MusicProgram.musicProgram.dataAccess.abstracts.MyListDao;
import com.MusicProgram.musicProgram.entities.concretes.MyList;
import com.MusicProgram.musicProgram.exception.CustomNotFoundException;
import com.MusicProgram.musicProgram.exception.CustomNotNullException;

@Service
public class MyListManager implements MyListService {

	@Autowired
	private MyListDao myListDao;

	@Override
	public MyList add(MyList myList) {
		Optional<MyList> my_List = Optional.empty();
		if (my_List.isPresent()) {
			return null;
		} else {
			return this.myListDao.save(myList);
		}
	}

	@Override
	@Cacheable(cacheNames = "myList")
	public List<MyList> getAllMyList() {
		Optional<MyList> myList = Optional.empty();
		if (myList.isPresent()) {
			return null;
		} else {
			return this.myListDao.findAll();
		}
	}

	@Override
	@Cacheable(cacheNames = "myList")
	public List<MyList> getByMusicName(String musicName) {

		if (myListDao.getByMusicName(musicName).isEmpty()) {
			throw new CustomNotFoundException("Not Found " + musicName);
		} else {
			return this.myListDao.getByMusicName(musicName);
		}

	}

	@Override
	@Cacheable(cacheNames = "myList")
	public List<MyList> getByPageable(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return this.myListDao.findAll(pageable).getContent();

	}

	@Override
	@Cacheable(cacheNames = "myList")
	public List<MyList> getByMusicNameStartsWith(String musicName) {

		if (myListDao.getByMusicNameStartsWith(musicName) != null) {
			return this.myListDao.getByMusicNameStartsWith(musicName);
		} else {
			throw new CustomNotFoundException("Not Found Startswith " + musicName + " in your values");
		}

	}

	@Override
	@Cacheable(cacheNames = "myList")
	public List<MyList> getByMusicNameContains(String musicName) {

		if (myListDao.getByMusicNameContains(musicName).isEmpty()) {
			throw new CustomNotFoundException("Not Found Contains " + musicName + " in your values");
		} else {
			return this.myListDao.getByMusicNameContains(musicName);
		}

	}

	@Override
	@CacheEvict(cacheNames = "myList")
	public void deleteById(int id) {
		Optional<MyList> myList = myListDao.findById(id);

		if (myList.isPresent()) {
			this.myListDao.deleteById(id);
		} else {
			throw new CustomNotFoundException("Not Found Id " + id);
		}

	}

	@Override
	public MyList update(int id, MyList myList) {
		Optional<MyList> optionalMyList = myListDao.findById(id);

		if (optionalMyList.isPresent()) {

			optionalMyList.get().setMusicName(myList.getMusicName());

			if (myList.getMusicName().isBlank() || myList.getMusicName().isEmpty()) {
				throw new CustomNotNullException("Not Null");
			} else {
				return this.myListDao.save(myList);
			}

		} else {
			throw new CustomNotFoundException("Not Found Id: " + id);
		}
	}

}
