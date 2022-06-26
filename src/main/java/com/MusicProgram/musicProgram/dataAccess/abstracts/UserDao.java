package com.MusicProgram.musicProgram.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.MusicProgram.musicProgram.entities.concretes.User;
import com.MusicProgram.musicProgram.entities.dto.CommentUserMusic;

public interface UserDao extends JpaRepository<User, Integer> {

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.CommentUserMusic(u.userName, m.musicName, c.comment) from User as u inner join u.comments as c inner join c.music as m where u.userName=:userName")
	List<CommentUserMusic> getByUserAndCommentAndMusic(String userName);

	@Query("From User where userName=:userName")
	List<User> getByUserName(String userName);

	List<User> getByUserNameContains(String userName);

	List<User> getByUserNameStartsWith(String userName);

}
