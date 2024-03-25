package com.synergisticit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.domain.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{
	public List<Passenger> findByUserNameLikeOrderByPassengerIdDesc(String userName);
}
