package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Airport;

public interface AirportService {
	public Airport save(Airport airport);
	public List<Airport> findAllAirport();
	public Airport findById(Long airportId);
	public void deleteAirport(Long airportId);
	public List<Airport> findAllAirportWithSort(String field);
}
