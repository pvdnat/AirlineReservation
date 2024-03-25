package com.synergisticit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synergisticit.domain.Gender;
import com.synergisticit.domain.Passenger;
import com.synergisticit.domain.Role;
import com.synergisticit.service.PassengerService;
import com.synergisticit.service.UserService;

import jakarta.validation.Valid;

@Controller
public class PassengerController {
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("passengerForm")
	public String passenger(Passenger passenger, Model model, Principal principal) {
		getData(model, principal);
		return "passengerForm";
	}
	
	@RequestMapping("savePassenger")
	public String savePassenger(@Valid @ModelAttribute Passenger passenger, BindingResult br, Model model, Principal principal) {
		passenger.setUserName(principal.getName());
		getData(model, principal);
		if (br.hasErrors()) {
			return "passengerForm";
		} else {
			passengerService.save(passenger);
			return "redirect:passengerForm";
		}
	}
	
	@RequestMapping("updatePassenger")
	public String updatePassenger(Passenger passenger, Model model, Principal principal) {
		Passenger p = passengerService.findById(passenger.getPassengerId());
		getData(model, principal);
		model.addAttribute("passenger", p);
		model.addAttribute("selectedGender", p.getPassengerGender());
		return "passengerForm";
	}
	
	@RequestMapping("deletePassenger")
	public String deletePassenger(Passenger passenger, Model model) {
		passengerService.deletePassenger(passenger.getPassengerId());;
		return "passengerForm";
	}
	
	public void getData(Model model, Principal principal) {
		List<String> r = userService.getRoleName(principal.getName());
		if (r.contains("Admin")) {
			model.addAttribute("allPassenger", passengerService.allPassenger());
		} else {
			model.addAttribute("allPassenger", passengerService.findByUserName(principal.getName()));
		}
		model.addAttribute("genders", Gender.values());
	}
	
}
