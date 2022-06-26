package com.MusicProgram.musicProgram.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MusicProgram.musicProgram.entities.concretes.Comment;
import com.MusicProgram.musicProgram.entities.dto.CommentUserMusic;

public interface CommentDao extends JpaRepository<Comment, Integer> {

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.CommentUserMusic(u.userName, m.musicName, c.comment) from User as u inner join u.comments as c inner join c.music as m")
	List<CommentUserMusic> getByCommentAndUserAndMusic();

	List<Comment> getByCommentContains(String comment);
}
