package com.synergisticit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synergisticit.domain.Airlines;
import com.synergisticit.domain.Flight;
import com.synergisticit.service.AirlinesService;
import com.synergisticit.service.AirportService;
import com.synergisticit.service.FlightService;

import jakarta.validation.Valid;

@Controller
public class FlightController {
	@Autowired
	FlightService flightService;
	
	@Autowired
	AirlinesService airlinesService;
	
	@Autowired
	AirportService airportService;
	
	@RequestMapping("flightForm")
	public String flight(Flight flight, Model model) {
		getData(model);
		return "flightForm";
	}
	
	@RequestMapping("updateFlight")
	public String upateFlight(Flight flight, Model model) {
		getData(model);
		Flight f = flightService.findById(flight.getFlightId());
		
		model.addAttribute("flight", f);
		model.addAttribute("selectedAirlines", f.getFlightAirlines());
		model.addAttribute("selectAirportDepartureCity", f.getDepartureCity());
		model.addAttribute("selectAirportArrivalCity", f.getArrivalCity());
		return "flightForm";
	}
	
	@RequestMapping("saveFlight")
	public String saveFlight(@Valid @ModelAttribute Flight flight, BindingResult br, Model model) {
		getData(model);
		
		if (br.hasErrors()) {
			model.addAttribute("hasError", true);
			return "flightForm";
		} else {
			
			airlinesService.saveAirlinesFlight(flight);
			
			return "redirect:flightForm";
		}
		
	}
	
	@RequestMapping("deleteFlight")
	public String deleteFlight(Flight flight, Model model) {
		flightService.deleteFlight(flight.getFlightId());
		return "redirect:fightForm";
	}
	
	
	public void getData(Model model) {
		model.addAttribute("allCompletedFlight", flightService.findAllCompletedFlight());
		model.addAttribute("allActiveFlight", flightService.findAllActiveFlight());
		model.addAttribute("airlines", airlinesService.findAllAirlines());
		model.addAttribute("airport", airportService.findAllAirport());
	}
}
