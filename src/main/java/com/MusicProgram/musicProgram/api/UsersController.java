package com.MusicProgram.musicProgram.api;

import java.util.List;
import java.util.Optional;

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

import com.MusicProgram.musicProgram.business.abstracts.UserService;
import com.MusicProgram.musicProgram.entities.concretes.User;
import com.MusicProgram.musicProgram.entities.dto.CommentUserMusic;

@RestController
@RequestMapping("/users/")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@GetMapping("getByUserAndCommentAndMusic")
	public ResponseEntity<List<CommentUserMusic>> getByUserAndCommentAndMusic(String userName) {
		return ResponseEntity.ok(this.userService.getByUserAndCommentAndMusic(userName));
	}
	
	@GetMapping("getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("getByUserNameContains") 
	public ResponseEntity<List<User>> getByUserNameContains(@RequestParam String userName) {
		return ResponseEntity.ok(this.userService.getByUserNameContains(userName));
	}
	
	@GetMapping("getAllUserPageAble")
	public ResponseEntity<List<User>> getAllUserPageAble(int pageNumber, int pageSize) {
		return ResponseEntity.ok(this.userService.getAllUserPageAble(pageNumber, pageSize));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<User>> getById(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.userService.getById(id));
	}
	
	@GetMapping("getByStartsWith")
	public ResponseEntity<List<User>> getByStartsWith(@RequestParam String userName) {
		return ResponseEntity.ok(this.userService.getByUserNameStartsWith(userName));
	}
	
	@PutMapping("updateUser/{id}")
	public ResponseEntity<User> update(@PathVariable("id") int id, @RequestBody User user) {
		return ResponseEntity.ok(this.userService.update(id, user));
	}
	
	@GetMapping("getByUserName")
	public ResponseEntity<List<User>> getByUserName(@RequestParam String userName) {
		return ResponseEntity.ok(this.userService.getByUserName(userName));
	}
	
	@PostMapping("add")
	public ResponseEntity<User> add(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		this.userService.delete(id);
		return ResponseEntity.ok("User deleted");
	}
	
}
