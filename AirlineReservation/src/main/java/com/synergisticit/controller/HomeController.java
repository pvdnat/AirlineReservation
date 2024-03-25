package com.synergisticit.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisticit.domain.Flight;
import com.synergisticit.domain.User;
import com.synergisticit.service.AirportService;
import com.synergisticit.service.FlightService;
import com.synergisticit.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;



@Controller
public class HomeController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	AirportService airportService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping({"/", "home"})
	public String homeForm(Model model) {
		return "home";
	}
	
	@RequestMapping("searchFight")
	public String searchFlight(HttpServletRequest req, Model model) {
		String fromCity = req.getParameter("departureCity");
		String toCity = req.getParameter("arrivalCity");
		LocalDate date = LocalDate.parse(req.getParameter("departureDate"));
		
		List<Flight> flights = flightService.searchFlights(fromCity, toCity, date);
		if (!flights.isEmpty()) {
			model.addAttribute("flights", flights);
		}
		return "home";
	}
	
	
}
