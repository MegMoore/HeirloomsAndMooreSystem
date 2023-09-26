package com.heirloomsandmooresystem.spring.client;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
	
	
	Iterable<Client> getClientByFirstNameAndLastName(String firstName, String lastName);

	Iterable<Client> getClientByLastName(String lastName);

	Optional<Client> getClientByUsername(String username);

	Iterable<Client> getClientByFirstName(String firstname);

	Optional<Client> findById(int Id);
}
