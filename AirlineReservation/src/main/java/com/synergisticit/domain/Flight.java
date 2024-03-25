package com.synergisticit.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long flightId;
	
	private String flightNumber;
	
	@ManyToOne
	private Airlines flightAirlines;
	
	private String departureCity;
	
	private String arrivalCity;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate flightDepartureDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime flightDepartureTime;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate flightArrivalDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime flightArrivalTime;
	
	private int flightCapacity;
	
	private double flightPrice;
	
	private int flightSeatsBooked;
		
}
