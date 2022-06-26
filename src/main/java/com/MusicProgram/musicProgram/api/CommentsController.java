package com.MusicProgram.musicProgram.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MusicProgram.musicProgram.business.abstracts.CommentsService;
import com.MusicProgram.musicProgram.entities.concretes.Comment;
import com.MusicProgram.musicProgram.entities.dto.CommentUserMusic;

@RestController
@RequestMapping("/comment")
public class CommentsController {

	@Autowired
	private CommentsService commentsService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Comment>> getAll() {
		return ResponseEntity.ok(this.commentsService.getAll());
	}
	
	@GetMapping("/getByCommentAndUserAndMusic")
	public ResponseEntity<List<CommentUserMusic>> getByCommentAndUserAndMusic() {
		return ResponseEntity.ok(this.commentsService.getByCommentAndUserAndMusic());
	}
	
	@GetMapping("/getAllPageAble") 
	public ResponseEntity<List<Comment>> getAllPageAble(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return ResponseEntity.ok(this.commentsService.getAllPageAble(pageNumber, pageSize));
	}
	
	@GetMapping("/getByCommentContains")
	public ResponseEntity<List<Comment>> getByCommentContains(@RequestParam String comment) {
		return ResponseEntity.ok(this.commentsService.getByCommentContains(comment));
	}
	
	@PostMapping("/add")
	public ResponseEntity<Comment> add(@RequestBody Comment comment) {
		return ResponseEntity.ok(this.commentsService.add(comment));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteById(@RequestParam int id) {
		this.commentsService.delete(id);
		return ResponseEntity.ok("Yorum Başarıyla Silindi");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Comment> update(@PathVariable("id") int id, @RequestBody Comment comment) {
		return ResponseEntity.ok(this.commentsService.update(id, comment));
	}
	
}
