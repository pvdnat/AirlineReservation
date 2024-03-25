package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Reservation;
import com.synergisticit.repository.ReservationRepository;

@Service
public class ReservationServiceImp implements ReservationService {
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation save(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> allReservation() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation findById(Long reservationNumber) {
		Optional<Reservation> r = reservationRepository.findById(reservationNumber);
		if (r.isPresent()) {
			return r.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteReservation(Long reservationNumber) {
		reservationRepository.deleteById(reservationNumber);
	}
	
	@Override
	public List<Reservation> findByUsername(String username) {
		List<Reservation> r = reservationRepository.findByUserNameLikeOrderByReservationNumberDesc(username);
		if (r.size()>0) return r;
		return null;
	}

	@Override
	public void update(Long resNumber, Boolean status, int bags) {
		Reservation r = findById(resNumber);
		r.setCheckedBags(bags);
		r.setCheckedIn(status);
		reservationRepository.save(r);
	}
	
}
