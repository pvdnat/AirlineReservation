package com.synergisticit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisticit.domain.Airlines;
import com.synergisticit.service.AirlinesService;

import jakarta.validation.Valid;

@Controller
public class AirlinesController {
	@Autowired
	AirlinesService airlinesService;
	
	@RequestMapping("airlinesForm")
	public String airlines(Airlines airlines, Model model) {
		getData(model);
		return "airlinesForm";
	}
	
	@RequestMapping("saveAirlines")
	public String saveAccount(@Valid @ModelAttribute Airlines airlines, BindingResult br, Model model, Principal principal) {
		getData(model);
		if(br.hasErrors()) {
			model.addAttribute("hasError", true);
			return "airlinesForm";
		} else {
			airlinesService.save(airlines);
			return "redirect:airlinesForm";
		}
	}
	
	@RequestMapping("updateAirlines")
	public String updateBranch(Airlines airlines, Model model) {
		Airlines a = airlinesService.findById(airlines.getAirlinesId());
		model.addAttribute("airlines", a);
		getData(model);
		return "airlinesForm";
	}
	
	@RequestMapping("deleteAirlines")
	public String deleteAirline(Airlines airlines, Model model) {
		airlinesService.deleteAirlines(airlines.getAirlinesId());
		return "redirect:airlinesForm";
	}
	
	public void getData(Model model) {
		model.addAttribute("allAirlines", airlinesService.findAllAirlines());
	}
	
	@RequestMapping("airlinesSort")
	public String airlinesWithSort(@RequestParam String field, Model model) {
		List<Airlines> airlines = airlinesService.findAllAirlinesWithSort(field);
		model.addAttribute("allAirlines", airlines);
		return "airlinesForm";
	}
}
