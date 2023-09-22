package com.heirloomsandmooresystem.spring.client;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
	
	
	Optional<Client> findClientByFirstNameAndLastName(String firstName, String lastName);

	Optional<Client> findClientByLastName(String lastName);

	Optional<Client> findClientByUsername(String username);
}
