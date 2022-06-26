package com.MusicProgram.musicProgram.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.MusicProgram.musicProgram.entities.concretes.User;
import com.MusicProgram.musicProgram.entities.dto.CommentUserMusic;

public interface UserService {

	User add(User user);
	User update(int id, User user);
	void delete(int id);
	Optional<User> getById(int id);
		
	List<User> getAllUsers();
	List<User> getAllUserPageAble(int pageNumber, int pageSize);
	List<User> getByUserNameStartsWith(String userName);
	List<User> getByUserName(String userName);
	List<User> getByUserNameContains(String userName);
	List<CommentUserMusic> getByUserAndCommentAndMusic(String userName);
	
}
