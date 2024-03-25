package com.synergisticit.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long passengerId;
	
	private String passengerFirstName;
	private String passengerLastName;
	
	private String passengerEmail;
	private String passengerPhoneNo;
	
	@Enumerated
	private Gender passengerGender;
	
	private String userName;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate passengerDOB;
	
	@Embedded
	private Address passengerAddress;
	
}
