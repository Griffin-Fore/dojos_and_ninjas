package com.griffinfore.dojos_and_ninjas2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.griffinfore.dojos_and_ninjas2.models.Dojo;
import com.griffinfore.dojos_and_ninjas2.services.DojoService;
import com.griffinfore.dojos_and_ninjas2.services.NinjaService;

import jakarta.validation.Valid;

// When you make a model, you need a repository and a service and a controller to go with it

// Which file is an interface?

@Controller
public class MainController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/")
	public String index(RedirectAttributes redirectAttributes) {
		return "redirect:/dojos/new";
	}

	@GetMapping("/dojos/new")
	public String home(@ModelAttribute("Dojos") Dojo dojo) {
		return "NewDojo.jsp";
	}
	
//	create new dojo route
	@PostMapping("/create/dojo")
	public String createDojoProcess(@Valid @ModelAttribute("Dojos") Dojo dojo, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "NewDojo.jsp";
		}
//		How to redirect to the dojo's page?
		dojoService.createDojo(dojo);
		Long Id = dojo.getId();
		redirectAttributes.addAttribute("Id", Id);
		return "redirect:/dojos/{Id}";
	}

	
//	show dojo page
	@GetMapping("/dojos/{Id}")
	public String one_dojo_page( @PathVariable Long Id, RedirectAttributes redirectAttributes, Model model) {
		Dojo oneDojo = dojoService.findOneDojo(Id);
		if(oneDojo==null) {
			return "redirect:/dojos/new";
		}
		model.addAttribute("oneDojo", oneDojo);
		return "OneDojo.jsp";
	}
}
