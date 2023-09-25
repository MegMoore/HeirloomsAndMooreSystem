package com.heirloomsandmooresystem.spring.quilt;

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
@RequestMapping("/api/quilts")
public class QuiltsController {

	@Autowired
	private QuiltRepository quiRepo;
	
	//Get All
	@GetMapping
	public ResponseEntity<Iterable<Quilt>> getQuilt(){
		Iterable<Quilt> quil= quiRepo.findAll();
		return new ResponseEntity<Iterable<Quilt>>(quil, HttpStatus.OK);
	}
	//Get By Id
	@GetMapping("{id}")//get by id
	public ResponseEntity<Quilt> getQuilt(@PathVariable int id){
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
		Optional<Quilt> qui = quiRepo.findById(id);
		if(qui.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Quilt>(qui.get(), HttpStatus.OK);
	}
	

		
	
	//Post
		@PostMapping
		public ResponseEntity<Quilt> postQuilt(@RequestBody Quilt qui){
			if(qui.getId() != 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			quiRepo.save(qui);
			return new ResponseEntity<Quilt>(qui, HttpStatus.CREATED);
		}
		
		//Put
		@PutMapping("{id}")
		public ResponseEntity putQuilt(@PathVariable int id, @RequestBody Quilt qui) {
			if(qui.getId() != id) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			quiRepo.save(qui);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		//Delete
		@DeleteMapping("{id}")
		public ResponseEntity deleteQuilt(@PathVariable int id) {
			if(id <= 0) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			quiRepo.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		//other methods
		
		private void findAreaTotal(@PathVariable Quilt qui) {
		qui.setArea(qui.getWidth() * qui.getLength());
		}
		
		
		
	
}
