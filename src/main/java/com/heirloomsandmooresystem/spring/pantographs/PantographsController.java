package com.heirloomsandmooresystem.spring.pantographs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/pantographs")
public class PantographsController {

	@Autowired
	private PantographRepository panRepo;
	
	//Get All
	@GetMapping
	public ResponseEntity<Iterable<Pantograph>> getPantograph(){
		Iterable<Pantograph> pant= panRepo.findAll();
		return new ResponseEntity<Iterable<Pantograph>>(pant, HttpStatus.OK);
	}
	//Get By Id
	@GetMapping("{id}")//get by id
	public ResponseEntity<Pantograph> getPantograph(@PathVariable int id){
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
		Optional<Pantograph> pan = panRepo.findById(id);
		if(pan.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pantograph>(pan.get(), HttpStatus.OK);
	}
	
	
	
	//Post
		@PostMapping
		public ResponseEntity<Pantograph> postPantograph(@RequestBody Pantograph pan){
			if(pan.getId() != 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			panRepo.save(pan);
			return new ResponseEntity<Pantograph>(pan, HttpStatus.CREATED);
		}
		
		//Put
		@PutMapping("{id}")
		public ResponseEntity putPantograph(@PathVariable int id, @RequestBody Pantograph pan) {
			if(pan.getId() != id) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			panRepo.save(pan);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		//Delete
		@DeleteMapping("{id}")
		public ResponseEntity deletePantograph(@PathVariable int id) {
			if(id <= 0) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			panRepo.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
}
