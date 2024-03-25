package com.synergisticit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long reservationNumber; //ticket number
	
	@ManyToOne
	private Passenger passenger;
	
	@ManyToOne
	private Flight flight;
	
	private int checkedBags;
	
	private boolean checkedIn;
	
	private String userName;
	
}
