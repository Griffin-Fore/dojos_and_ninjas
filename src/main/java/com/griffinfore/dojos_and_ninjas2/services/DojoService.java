package com.griffinfore.dojos_and_ninjas2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.griffinfore.dojos_and_ninjas2.models.Dojo;
import com.griffinfore.dojos_and_ninjas2.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository repo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.repo = dojoRepo;	
	}
	
//	Finds only dojos by using the return
	public List<Dojo> allDojos() {
		return repo.findAll();
	}
//	What if a ninja and a dojo share the same id?
//	The return determines what information you accessing
	
	public Dojo findOneDojo(Long Id) {
		return repo.findById(Id).orElse(null);
	}
	
	public Dojo createDojo(Dojo dojo) {	
		return repo.save(dojo);
	}
}
