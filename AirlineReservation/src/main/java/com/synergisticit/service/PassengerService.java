package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Passenger;

public interface PassengerService {
	public Passenger save(Passenger passenger);
	public List<Passenger> allPassenger();
	public Passenger findById(Long passengerId);
	public void deletePassenger(Long passengerId);
	public List<Passenger> findByUserName(String username);
}
