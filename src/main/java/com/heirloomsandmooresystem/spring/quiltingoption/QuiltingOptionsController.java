package com.heirloomsandmooresystem.spring.quiltingoption;

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

import com.heirloomsandmooresystem.spring.product.Product;
import com.heirloomsandmooresystem.spring.product.ProductRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/quiltingoptions")
public class QuiltingOptionsController {

	@Autowired
	private QuiltingOptionRepository quopRepo;
	
	//Get All
	@GetMapping
	public ResponseEntity<Iterable<QuiltingOption>> getQuiltingOption(){
		Iterable<QuiltingOption> quopt= quopRepo.findAll();
		return new ResponseEntity<Iterable<QuiltingOption>>(quopt, HttpStatus.OK);
	}
	//Get By Id
	@GetMapping("{id}")//get by id
	public ResponseEntity<QuiltingOption> getQuiltingOption(@PathVariable int id){
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
		Optional<QuiltingOption> quop = quopRepo.findById(id);
		if(quop.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<QuiltingOption>(quop.get(), HttpStatus.OK);
	}
	
	
	
	//Post
		@PostMapping
		public ResponseEntity<QuiltingOption> postQuiltingOption(@RequestBody QuiltingOption quop){
			if(quop.getId() != 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			quopRepo.save(quop);
			return new ResponseEntity<QuiltingOption>(quop, HttpStatus.CREATED);
		}
		
		//Put
		@PutMapping("{id}")
		public ResponseEntity putQuiltingOption(@PathVariable int id, @RequestBody QuiltingOption quop) {
			if(quop.getId() != id) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			quopRepo.save(quop);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		//Delete
		@DeleteMapping("{id}")
		public ResponseEntity deleteQuiltingOption(@PathVariable int id) {
			if(id <= 0) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			quopRepo.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
}
