package com.heirloomsandmooresystem.spring.quilt;

import org.springframework.data.repository.CrudRepository;

public interface QuiltRepository extends CrudRepository<Quilt, Integer>{

	Iterable<Quilt> findByStatus(String string);

	Iterable<Quilt> findAllById(int id);

	

	
}
