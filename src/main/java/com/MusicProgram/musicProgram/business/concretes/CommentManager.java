package com.MusicProgram.musicProgram.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MusicProgram.musicProgram.business.abstracts.CommentsService;
import com.MusicProgram.musicProgram.dataAccess.abstracts.CommentDao;
import com.MusicProgram.musicProgram.entities.concretes.Comment;
import com.MusicProgram.musicProgram.entities.dto.CommentUserMusic;
import com.MusicProgram.musicProgram.exception.CustomNotFoundException;
import com.MusicProgram.musicProgram.exception.CustomNotNullException;
import com.MusicProgram.musicProgram.exception.InternalServerError;

@Service
public class CommentManager implements CommentsService {

	@Autowired
	private CommentDao commentDao;

	@Override
	@Cacheable(cacheNames = "comment")
	public List<Comment> getAll() {
		return this.commentDao.findAll();
	}

	@Override
	public Comment add(Comment comment) {

		if (commentDao.save(comment).getComment().isEmpty() || commentDao.save(comment).getComment().isBlank()) {
			throw new InternalServerError("Not Null");
		} else {
			return this.commentDao.save(comment);
		}

	}

	@Override
	@Cacheable(cacheNames = "comment")
	public List<CommentUserMusic> getByCommentAndUserAndMusic() {
		return this.commentDao.getByCommentAndUserAndMusic();
	}

	@Override
	@Cacheable(cacheNames = "comment")
	public List<Comment> getAllPageAble(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return this.commentDao.findAll(pageable).getContent();
	}

	@Override
	@CacheEvict(cacheNames = "comment")
	public void delete(int id) {
		Optional<Comment> optionalDelete = commentDao.findById(id);

		if (optionalDelete.isPresent()) {
			this.commentDao.deleteById(id);
		} else {
			throw new InternalServerError("Not Found Id " + id);
		}

	}

	@Override
	public Comment update(int id, Comment comment) {
		Optional<Comment> updateComment = commentDao.findById(id);

		if (updateComment.isPresent()) {

			updateComment.get().setComment(comment.getComment());

			if (comment.getComment().isBlank() || comment.getComment().isEmpty()) {
				throw new CustomNotNullException("Not Null");
			} else {
				return this.commentDao.save(comment);
			}

		} else {
			throw new CustomNotFoundException("Not Found");
		}

	}

	@Override
	@Cacheable(cacheNames = "comment")
	public List<Comment> getByCommentContains(String comment) {

		if (commentDao.getByCommentContains(comment).isEmpty()) {
			throw new CustomNotFoundException("Not Found");
		} else {
			return this.commentDao.getByCommentContains(comment);
		}

	}

}
