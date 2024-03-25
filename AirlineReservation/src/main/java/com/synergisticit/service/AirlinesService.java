package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Airlines;
import com.synergisticit.domain.Flight;

public interface AirlinesService {
	public Airlines save(Airlines airlines);
	public List<Airlines> findAllAirlines();
	public Airlines findById(Long airlinesId);
	public void deleteAirlines(Long airlinesId);
	public void saveAirlinesFlight(Flight flight);
	
	public List<Airlines> findAllAirlinesWithSort(String field);
}
