package com.griffinfore.dojos_and_ninjas2.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.griffinfore.dojos_and_ninjas2.models.Dojo;

// The Interface
public interface DojoRepository extends CrudRepository<Dojo, Long>{
//	Built in of CrudRepository Find All with Name
	List<Dojo> findAll();
// Create new methods using keywords
}