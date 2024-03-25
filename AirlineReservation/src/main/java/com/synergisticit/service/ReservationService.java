package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Reservation;

public interface ReservationService {
	public Reservation save(Reservation reservation);
	public List<Reservation> allReservation();
	public Reservation findById(Long reservationNumber);
	public void deleteReservation(Long reservationNumber);
	
	List<Reservation> findByUsername(String username);
	public void update(Long resNumber, Boolean status, int bags);
	
}
