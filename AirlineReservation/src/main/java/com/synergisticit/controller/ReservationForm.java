package com.synergisticit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synergisticit.domain.Flight;
import com.synergisticit.domain.Reservation;
import com.synergisticit.service.FlightService;
import com.synergisticit.service.PassengerService;
import com.synergisticit.service.ReservationService;

import jakarta.validation.Valid;

@Controller
public class ReservationForm {
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	FlightService flightService;
	
	@RequestMapping("reservationForm") 
	public String reservation(Flight flight, Reservation reservation, Model model, Principal principal) {
		getData(flight, model, principal.getName());
		return "reservationForm";
	}

	@RequestMapping("saveReservation")
	public String saveReservation(@Valid @ModelAttribute Reservation reservation, Flight flight, BindingResult br, Model model, Principal principal) {
		getData(flight, model, principal.getName());
		if (br.hasErrors()) {
			return "reservationForm";
		} else {
			reservation.setUserName(principal.getName());
			reservation.setFlight(flight);
			reservation.setCheckedIn(false);
			reservation.setCheckedBags(0);
			reservationService.save(reservation);
			
			Flight f = flightService.findById(flight.flightId);
			f.setFlightSeatsBooked(f.getFlightSeatsBooked()+1);
			flightService.save(f);
			return "redirect:flightForm";
		}
	}
	
	
	public void getData(Flight flight, Model model, String username) {
		model.addAttribute("flightInfo", flightService.findById(flight.getFlightId()));
		model.addAttribute("passengers", passengerService.findByUserName(username));
	}
}
