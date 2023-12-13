package com.griffinfore.dojos_and_ninjas2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.griffinfore.dojos_and_ninjas2.models.Ninja;
import com.griffinfore.dojos_and_ninjas2.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository repo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.repo = ninjaRepo;
	}
	public List<Ninja> allNinjas() {
		return repo.findAll();
	}
	
	public Ninja findOneNinja(Long Id) {
		return repo.findById(Id).orElse(null);
	}
	public Ninja createNinja(Ninja ninja) {
		return repo.save(ninja);
	}
}