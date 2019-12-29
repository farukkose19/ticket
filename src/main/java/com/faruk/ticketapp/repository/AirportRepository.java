package com.faruk.ticketapp.repository;

import com.faruk.ticketapp.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findAirportsByNameStartingWith(String name);
    Airport findAirportById(Long id);
}
