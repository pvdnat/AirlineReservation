package com.synergisticit.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Airport {
	
	@Id
	public Long airportId;
	
	private String airportCode;
	
	private String airportName;
	
	private String airportCity;
	
	@OneToMany
	private List<Flight> airportArrivalFlights = new ArrayList<>();
	
	@OneToMany
	private List<Flight> airportDepartureFlights = new ArrayList<>();
}
