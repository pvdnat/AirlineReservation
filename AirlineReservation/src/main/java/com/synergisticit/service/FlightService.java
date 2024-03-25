package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Flight;

import java.time.LocalDate;


public interface FlightService {
	public Flight save(Flight flight);
	public List<Flight> findAllFlight();
	public Flight findById(Long flightId);
	public void deleteFlight(Long flightId);
	public List<Long> getAllFlightId();
	public List<Flight> searchFlights(String fromCity, String toCity, LocalDate date);
	public List<Flight> findAllActiveFlight();
	public List<Flight> findAllCompletedFlight();

}
