package com.MusicProgram.musicProgram.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MusicProgram.musicProgram.business.abstracts.UserService;
import com.MusicProgram.musicProgram.dataAccess.abstracts.UserDao;
import com.MusicProgram.musicProgram.entities.concretes.User;
import com.MusicProgram.musicProgram.entities.dto.CommentUserMusic;
import com.MusicProgram.musicProgram.exception.CustomNotFoundException;
import com.MusicProgram.musicProgram.exception.CustomNotNullException;

@Service
public class UserManager implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Cacheable(cacheNames = "user")
	public List<CommentUserMusic> getByUserAndCommentAndMusic(String userName) {

		if (userDao.getByUserAndCommentAndMusic(userName).isEmpty()) {
			throw new CustomNotFoundException("Not Found " + userName);
		} else {
			return this.userDao.getByUserAndCommentAndMusic(userName);
		}

	}

	@Override
	public User add(User user) {

		if (user.getUserName().isBlank() || user.getUserName().isEmpty()) {
			throw new CustomNotNullException("Not Null UserName");
		} else {
			return this.userDao.save(user);
		}

	}

	@Override
	@Cacheable(cacheNames = "user")
	public List<User> getAllUsers() {
		Optional<List<User>> user = Optional.empty();
		if (user.isPresent()) {
			throw new CustomNotFoundException("Not Found Values");
		} else {
			return this.userDao.findAll();
		}

	}

	@Override
	@Cacheable(cacheNames = "user")
	public List<User> getByUserName(String userName) {

		if (userDao.getByUserName(userName).isEmpty()) {
			throw new CustomNotFoundException("Not Found " + userName);
		} else {
			return this.userDao.getByUserName(userName);
		}

	}

	@Override
	@Cacheable(cacheNames = "user")
	public List<User> getByUserNameContains(String userName) {

		if (userDao.getByUserNameContains(userName).isEmpty()) {
			throw new CustomNotFoundException("Not Found " + userName + " your values");
		} else {
			return this.userDao.getByUserNameContains(userName);
		}

	}

	@Override
	@Cacheable(cacheNames = "user")
	public List<User> getAllUserPageAble(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return this.userDao.findAll(pageable).getContent();

	}

	@Override
	@Cacheable(cacheNames = "user")
	public Optional<User> getById(int id) {
		Optional<User> optıonalId = userDao.findById(id);
		if (optıonalId.isPresent()) {
			return this.userDao.findById(id);
		} else {
			throw new CustomNotFoundException("Not Found " + id + " Id");
		}

	}

	@Override
	@Cacheable(cacheNames = "user")
	public List<User> getByUserNameStartsWith(String userName) {

		if (userDao.getByUserNameStartsWith(userName).isEmpty()) {
			throw new CustomNotFoundException("Not Found Startswith " + userName);
		} else {
			return this.userDao.getByUserNameStartsWith(userName);
		}

	}

	@Override
	public User update(int id, User user) {
		Optional<User> optionalUser = userDao.findById(id);

		if (optionalUser.isPresent()) {

			optionalUser.get().setUserName(user.getUserName());
			optionalUser.get().setUserNickName(user.getUserNickName());
			optionalUser.get().setUserEmail(user.getUserEmail());
			optionalUser.get().setUserPassword(user.getUserPassword());

			if (user.getUserName().isBlank() || user.getUserName().isEmpty()) {
				throw new CustomNotNullException("Not Null");
			} else {
				return this.userDao.save(user);
			}
		} else {
			throw new CustomNotFoundException("Not Found Id: " + id);
		}

	}

	@Override
	@CacheEvict(cacheNames = "user")
	public void delete(int id) {
		Optional<User> optionalUser = userDao.findById(id);

		if (optionalUser.isPresent()) {
			this.userDao.deleteById(id);
		} else {
			throw new CustomNotFoundException("Not Found Id " + id);
		}

	}
}
