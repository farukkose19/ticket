package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.model.Airline;
import com.faruk.ticketapp.model.Flight;
import com.faruk.ticketapp.repository.FlightRepository;
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
@RequestMapping(value = "/flight")
public class FlightController {

    @Autowired
    private FlightRepository repository;

    @Autowired
    private RouteRepository routeRepository;

    @RequestMapping("/save")
    public ResponseEntity<Flight> save(@RequestBody Flight flight) {
        try {
            flight.setRoute(routeRepository.findRouteById(flight.getRoute().getId()));
            repository.save(flight);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @RequestMapping("/getRouteFlight")
    public List<Flight> getRouteFlight(@RequestParam Long id) {
        return repository.findFlightsByRoute(routeRepository.findRouteById(id));
    }

    @RequestMapping("/getFlight")
    public Flight getFlight(@RequestParam Long id) {
        return repository.findFlightById(id);
    }
}
