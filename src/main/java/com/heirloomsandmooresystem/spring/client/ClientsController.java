package com.heirloomsandmooresystem.spring.client;

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
@RequestMapping("/api/clients")
public class ClientsController {

	@Autowired
	private ClientRepository cliRepo;
	
	//Get All
	@GetMapping
	public ResponseEntity<Iterable<Client>> getClient(){
		Iterable<Client> clin= cliRepo.findAll();
		return new ResponseEntity<Iterable<Client>>(clin, HttpStatus.OK);
	}
	//Get By Id
	@GetMapping("{id}")//get by id
	public ResponseEntity<Client> getClient(@PathVariable int id){
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
		Optional<Client> cli = cliRepo.findById(id);
		if(cli.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(cli.get(), HttpStatus.OK);
	}
	
	//Get By username
	@GetMapping("{username}")//get client by username 
	public ResponseEntity<Client> getUserByUsername(@PathVariable String username){
		Optional<Client> cli = cliRepo.findClientByUsername(username);
		if(cli.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(cli.get(), HttpStatus.OK);
	
	}
	
	//Get By lastname
		@GetMapping("lastname/{lastname}")//get client by lastname
		public ResponseEntity<Client> getUserByLastName(@PathVariable String lastName){
			Optional<Client> cli = cliRepo.findClientByLastName(lastName);
			if(cli.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Client>(cli.get(), HttpStatus.OK);
		
		}
	
	//Get By firstname lastname
		@GetMapping("{firstname}/{lastname}")//get client by firstname and lastname
		public ResponseEntity<Client> getClientByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
			Optional<Client> cli = cliRepo.findClientByFirstNameAndLastName(firstName, lastName);
			if(cli.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Client>(cli.get(), HttpStatus.OK);
			}
	
	//Post
		@PostMapping
		public ResponseEntity<Client> postClient(@RequestBody Client cli){
			if(cli.getId() != 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			cliRepo.save(cli);
			return new ResponseEntity<Client>(cli, HttpStatus.CREATED);
		}
		
		//Put
		@PutMapping("{id}")
		public ResponseEntity putClient(@PathVariable int id, @RequestBody Client cli) {
			if(cli.getId() != id) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			cliRepo.save(cli);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		//Delete
		@DeleteMapping("{id}")
		public ResponseEntity deleteClient(@PathVariable int id) {
			if(id <= 0) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			cliRepo.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
}
