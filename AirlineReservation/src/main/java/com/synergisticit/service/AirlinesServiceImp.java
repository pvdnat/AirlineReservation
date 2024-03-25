package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Airlines;
import com.synergisticit.domain.Flight;
import com.synergisticit.repository.AirlinesRepository;
import com.synergisticit.repository.FlightRepository;

@Service
public class AirlinesServiceImp implements AirlinesService{
	@Autowired
	AirlinesRepository airlinesRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public Airlines save(Airlines airlines) {
		return airlinesRepository.save(airlines);
	}

	@Override
	public List<Airlines> findAllAirlines() {
		return airlinesRepository.findAll();
	}

	@Override
	public Airlines findById(Long airlinesId) {
		Optional<Airlines> optionalAirline = airlinesRepository.findById(airlinesId);
		if (optionalAirline.isPresent()) {
			return optionalAirline.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteAirlines(Long airlinesId) {
		airlinesRepository.deleteById(airlinesId);
	}

	@Override
	public void saveAirlinesFlight(Flight flight) {
		flightRepository.save(flight);
		Airlines a = flight.getFlightAirlines();
		List<Flight> existedFlight = a.getAirlinesFlights();
		existedFlight.add(flight);
		a.setAirlinesFlights(existedFlight);
		airlinesRepository.save(a);
	}

	@Override
	public List<Airlines> findAllAirlinesWithSort(String field) {
		return airlinesRepository.findAll(Sort.by(field));
	}
	
}