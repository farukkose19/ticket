package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.model.Airport;
import com.faruk.ticketapp.model.Flight;
import com.faruk.ticketapp.model.Route;
import com.faruk.ticketapp.repository.AirportRepository;
import com.faruk.ticketapp.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/route")
public class RouteController {

    @Autowired
    private RouteRepository repository;

    @Autowired
    private AirportRepository airportRepository;

    @RequestMapping("/save")
    public ResponseEntity<Route> save(@RequestBody Route route) {
        try {
            Airport arrival = airportRepository.findAirportById(route.getArrival().getId());
            Airport departure = airportRepository.findAirportById(route.getDeparture().getId());
            if (arrival == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (departure == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (arrival == departure) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (repository.findRouteByArrivalAndDeparture(arrival, departure) != null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            route.setArrival(arrival);
            route.setDeparture(departure);
            repository.save(route);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @RequestMapping("/getRoute")
    public Route getRoute(@RequestParam Long id) {
        return repository.findRouteById(id);
    }

    @RequestMapping("/getRouteByArrivalAndDeparture")
    public Route getRouteByArrivalAndDeparture(@RequestParam Long arrivalId, @RequestParam Long departureId) {
        return repository.findRouteByArrivalAndDeparture(airportRepository.findAirportById(arrivalId),
                airportRepository.findAirportById(departureId));
    }

}
