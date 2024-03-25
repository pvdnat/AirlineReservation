package com.synergisticit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synergisticit.domain.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	List<Flight> findByDepartureCityLikeAndArrivalCityLikeOrderByFlightIdAsc(String fromCity, String toCity);

	List<Flight> findAllByFlightDepartureDateGreaterThanEqualOrderByFlightIdAsc(LocalDate now);

	List<Flight> findAllByFlightDepartureDateLessThanEqualOrderByFlightIdAsc(LocalDate now);
}
