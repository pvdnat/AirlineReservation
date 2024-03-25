package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synergisticit.service.ReservationService;

@RestController
public class ReservationHistoryRest {
	@Autowired
	ReservationService reservationService;
	/*
	@RequestMapping(value = "/checkIn/{resNumber}/{status}/{bags}", method = RequestMethod.POST)
	public String checkIn(@RequestParam("resNumber") Long resNumber, @RequestParam("status") Boolean status, @RequestParam("bags") int bags) {
		reservationService.update(resNumber, status, bags);
		return "reservationHistory";
	}
	*/
}
