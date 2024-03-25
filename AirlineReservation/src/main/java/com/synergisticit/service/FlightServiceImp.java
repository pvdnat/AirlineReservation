package com.synergisticit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Flight;
import com.synergisticit.repository.FlightRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class FlightServiceImp implements FlightService{
	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public Flight save(Flight flight) {
		return flightRepository.save(flight);
	}
	
	
	@Override
	public List<Flight> findAllFlight() {
		return flightRepository.findAll();
	}
	
	@Override
	public Flight findById(Long airportId) {
		Optional<Flight> optionalAirport = flightRepository.findById(airportId);
		if (optionalAirport.isPresent()) {
			return optionalAirport.get();
		} else {
			return null;
		}
	}
	
	@Override
	public void deleteFlight(Long flightId) {
		flightRepository.deleteById(flightId);
	}


	@Override
	public List<Long> getAllFlightId() {
		List<Long> flightId = new ArrayList<>();
		List<Flight> flightList = flightRepository.findAll();
		for (Flight f : flightList) {
			flightId.add(f.getFlightId());
		}
		
		return flightId;
	}


	@Override
	public List<Flight> searchFlights(String fromCity, String toCity, LocalDate date) {
		List<Flight> finalFlights = new ArrayList<Flight>();
		List<Flight> flights = flightRepository.findByDepartureCityLikeAndArrivalCityLikeOrderByFlightIdAsc(fromCity, toCity);
		LocalDate now = LocalDate.now();
		if (!flights.isEmpty()) {
			for (Flight f : flights) {
				if (f.getFlightDepartureDate().isEqual(date) && ( date.isEqual(now) || date.isAfter(now)) ){
					finalFlights.add(f);
				}
			}
			return finalFlights;
		} else {
			return null;
		}
	}

	@Override
	public List<Flight> findAllActiveFlight() {
		LocalDate now = LocalDate.now();
		return flightRepository.findAllByFlightDepartureDateGreaterThanEqualOrderByFlightIdAsc(now);
		
	}

	@Override
	public List<Flight> findAllCompletedFlight() {
		LocalDate now = LocalDate.now();
		return flightRepository.findAllByFlightDepartureDateLessThanEqualOrderByFlightIdAsc(now);
	}
	
	
}
