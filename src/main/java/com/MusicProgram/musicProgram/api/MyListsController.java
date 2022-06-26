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

import com.MusicProgram.musicProgram.business.abstracts.MyListService;
import com.MusicProgram.musicProgram.entities.concretes.MyList;

@RestController
@RequestMapping("/mylist/")
public class MyListsController {

	@Autowired
	private MyListService myListService;

	@GetMapping("getAllMyList")
	public ResponseEntity<List<MyList>> getAllMyList() {
		return ResponseEntity.ok(this.myListService.getAllMyList());
	}
	
	@GetMapping("getByMusicName")
	public ResponseEntity<List<MyList>> getByMusicName(@RequestParam String musicName) {
		return ResponseEntity.ok(this.myListService.getByMusicName(musicName));
	}
	
	@GetMapping("getByPageable")
	public ResponseEntity<List<MyList>> getByPageable(@RequestParam int pageNo, @RequestParam int pageSize) {
		return ResponseEntity.ok(this.myListService.getByPageable(pageNo, pageSize));
	}
	
	@GetMapping("getByMusicNameStartsWith")
	public ResponseEntity<List<MyList>> getByMusicNameStartsWith(@RequestParam String musicName) {
		return ResponseEntity.ok(this.myListService.getByMusicNameStartsWith(musicName));
	}
	
	@GetMapping("getByMusicNameContains")
	public ResponseEntity<List<MyList>> getByMusicNameContains(@RequestParam String musicName) {
		return ResponseEntity.ok(this.myListService.getByMusicNameContains(musicName));
	}
	
	@PostMapping("addToMyList")
	public ResponseEntity<MyList> add(@RequestBody MyList myList) {
		return ResponseEntity.ok(this.myListService.add(myList));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		this.myListService.deleteById(id);
		return ResponseEntity.ok("Listede ki müzik silindi.");
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<MyList> update(@PathVariable("id") int id, @RequestBody MyList myList) {
		return ResponseEntity.ok(this.myListService.update(id, myList));
	}
}