package com.faruk.ticketapp.repository;

import com.faruk.ticketapp.model.Flight;
import com.faruk.ticketapp.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findFlightsByRoute(Route route);
    Flight findFlightById(Long id);
}
