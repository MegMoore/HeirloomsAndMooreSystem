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
	public ResponseEntity<Client> getById(@PathVariable int id){
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
	@GetMapping("username/{username}")//get client by username 
	public ResponseEntity<Client> getClientByUsername(@PathVariable String username){
		Optional<Client> cli = cliRepo.getClientByUsername(username);
		if(cli.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(cli.get(), HttpStatus.OK);
	
	}
	
	//Get By lastname
		@GetMapping("lastname/{lastname}")//get client by lastname
		public ResponseEntity<Iterable<Client>> getClientByLastName(@PathVariable String lastname){
			Iterable<Client> cli = cliRepo.getClientByLastName(lastname);
			
			return new ResponseEntity<Iterable<Client>>(cli, HttpStatus.OK);
		
		}
	
	//Get By firstname lastname
		@GetMapping("{firstname}/{lastname}")//get client by firstname and lastname
		public ResponseEntity<Iterable<Client>> getByClientFirstNameAndLastName(@PathVariable String firstname, @PathVariable String lastname){
			Iterable<Client> cli = cliRepo.getClientByFirstNameAndLastName(firstname, lastname);
			
			return new ResponseEntity<Iterable<Client>>(cli, HttpStatus.OK);
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
