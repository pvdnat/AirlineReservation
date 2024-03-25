package com.synergisticit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisticit.domain.Airport;
import com.synergisticit.service.AirportService;

import jakarta.validation.Valid;

@Controller
public class AirportController {
	@Autowired
	AirportService airportService;
	
	@RequestMapping("airportForm")
	public String airlines(Airport airport, Model model) {
		getData(model);
		return "airportForm";
	}
	
	@RequestMapping("saveAirport")
	public String saveAirport(@Valid @ModelAttribute Airport airport, BindingResult br, Model model) {
		getData(model);
		if(br.hasErrors()) {
			model.addAttribute("hasError", true);
			return "airportForm";
		} else {
			airportService.save(airport);
			return "redirect:airportForm";
		}
	}
	
	@RequestMapping("updateAirport")
	public String updateAirport(Airport airport, Model model) {
		Airport a = airportService.findById(airport.getAirportId());
		model.addAttribute("airport", a);
		getData(model);
		return "airportForm";
	}
	
	@RequestMapping("deleteAirport")
	public String deleteAirport(Airport airport, Model model) {
		airportService.deleteAirport(airport.getAirportId());
		return "redirect:airportForm";
	}
	
	public void getData(Model model) {
		model.addAttribute("allAirport", airportService.findAllAirport());
	}
	
	@RequestMapping("airportSort")
	public String airlinesSort(@RequestParam String field, Model model) {
		List<Airport> airport = airportService.findAllAirportWithSort(field);
		model.addAttribute("allAirport", airport);
		return "airportForm";
	}
}
