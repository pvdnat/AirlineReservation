package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Airport;
import com.synergisticit.repository.AirportRepository;

@Service
public class AirportServiceImp implements AirportService{
	@Autowired
	AirportRepository airportRepository;
	
	@Override
	public Airport save(Airport airport) {
		return airportRepository.save(airport);
	}
	
	
	@Override
	public List<Airport> findAllAirport() {
		return airportRepository.findAll();
	}
	
	@Override
	public Airport findById(Long airportId) {
		Optional<Airport> optionalAirport = airportRepository.findById(airportId);
		if (optionalAirport.isPresent()) {
			return optionalAirport.get();
		} else {
			return null;
		}
	}
	
	@Override
	public void deleteAirport(Long airportId) {
		airportRepository.deleteById(airportId);
	}


	@Override
	public List<Airport> findAllAirportWithSort(String field) {
		return airportRepository.findAll(Sort.by(field));
	}
}
