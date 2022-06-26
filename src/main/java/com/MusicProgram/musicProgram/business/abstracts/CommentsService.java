package com.MusicProgram.musicProgram.business.abstracts;

import java.util.List;

import com.MusicProgram.musicProgram.entities.concretes.Comment;
import com.MusicProgram.musicProgram.entities.dto.CommentUserMusic;

public interface CommentsService {

	Comment add(Comment comment);
	
	Comment update(int id, Comment comment);
	void delete(int id);
	
	List<Comment> getAll();
	List<Comment> getByCommentContains(String comment);
	List<Comment> getAllPageAble(int pageNumber, int pageSize);
	List<CommentUserMusic> getByCommentAndUserAndMusic();
	
}
