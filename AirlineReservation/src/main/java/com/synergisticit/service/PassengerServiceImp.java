package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Passenger;
import com.synergisticit.repository.PassengerRepository;

@Service
public class PassengerServiceImp implements PassengerService {
	@Autowired
	PassengerRepository passengerRepository;
	
	@Override
	public Passenger save(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	@Override
	public List<Passenger> allPassenger() {
		return passengerRepository.findAll();
	}

	@Override
	public Passenger findById(Long passengerId) {
		Optional<Passenger> p = passengerRepository.findById(passengerId);
		if (p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}

	@Override
	public void deletePassenger(Long passengerId) {
		passengerRepository.deleteById(passengerId);
	}

	@Override
	public List<Passenger> findByUserName(String username) {
		List<Passenger> p = passengerRepository.findByUserNameLikeOrderByPassengerIdDesc(username);
		if (p.size()>0) return p;
		return null;
	}

	

}
