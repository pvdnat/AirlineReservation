package com.synergisticit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisticit.domain.Reservation;
import com.synergisticit.service.ReservationService;
import com.synergisticit.service.UserService;

@Controller
public class ReservationHistoryController {
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("reservationHistory")
	public String reservation(Reservation reservation, Model model, Principal principal) {
		getData(model, principal);
		return "reservationHistory";
	}
		
	public void getData(Model model, Principal principal) {
		List<String> r = userService.getRoleName(principal.getName());
		if (r.contains("Admin")) {
			model.addAttribute("allReservation", reservationService.allReservation());
		} else {
			model.addAttribute("allReservation", reservationService.findByUsername(principal.getName()));
		}
	}
	
	@RequestMapping(value = "/checkIn") 
	public String checkIn(@RequestParam Long reservationId, @RequestParam Boolean status, @RequestParam int bags , Model model, Principal principal) {
		reservationService.update(reservationId, status, bags);
		getData(model, principal);
		return "reservationHistory";
	}
}
