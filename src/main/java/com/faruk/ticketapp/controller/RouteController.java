package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.model.Route;
import com.faruk.ticketapp.model.User;
import com.faruk.ticketapp.repository.AirlineRepository;
import com.faruk.ticketapp.repository.AirportRepository;
import com.faruk.ticketapp.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/route")
public class RouteController {

    @Autowired
    private RouteRepository repository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirportRepository airportRepository;

    @RequestMapping("/save")
    public Route save(@RequestBody Route route) {
        route.setArrival(airportRepository.findAirportById(route.getArrival().getId()));
        route.setDeparture(airportRepository.findAirportById(route.getDeparture().getId()));
        return repository.save(route);
    }
}
