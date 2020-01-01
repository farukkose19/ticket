package com.faruk.ticketapp.repository;

import com.faruk.ticketapp.model.Airport;
import com.faruk.ticketapp.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    Route findRouteById(Long id);
    Route findRouteByArrivalAndDeparture(Airport arrival, Airport departure);
}
