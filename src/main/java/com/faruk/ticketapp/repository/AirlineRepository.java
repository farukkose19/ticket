package com.faruk.ticketapp.repository;

import com.faruk.ticketapp.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

    List<Airline> findAirlinesByNameStartingWith(String name);
    Airline findAirlineById(Long id);

}
