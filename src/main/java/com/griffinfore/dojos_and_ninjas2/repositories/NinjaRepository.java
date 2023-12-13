package com.griffinfore.dojos_and_ninjas2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.griffinfore.dojos_and_ninjas2.models.Ninja;


public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
}
