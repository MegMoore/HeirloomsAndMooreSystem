package com.heirloomsandmooresystem.spring.quilt;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface QuiltRepository extends CrudRepository<Quilt, Integer>{

	Iterable<Quilt> findByStatus(String string);

	
}
