package com.griffinfore.dojos_and_ninjas2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.griffinfore.dojos_and_ninjas2.models.Dojo;
import com.griffinfore.dojos_and_ninjas2.models.Ninja;
import com.griffinfore.dojos_and_ninjas2.services.DojoService;
import com.griffinfore.dojos_and_ninjas2.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	// create ninja page
//	The modelAttributes needs to be in the display and the create route
	@GetMapping("/ninjas/new")
	public String ninja_page(@ModelAttribute("Ninjas") Ninja ninja, Model model ) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "NewNinja.jsp";
	}

// create new ninja route
	@PostMapping("/create/ninja")
	public String createNinjaProcess(@Valid @ModelAttribute("Ninjas") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "NewNinja.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/";
	}
}
