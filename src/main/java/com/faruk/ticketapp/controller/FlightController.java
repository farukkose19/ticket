package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.model.Airline;
import com.faruk.ticketapp.model.Flight;
import com.faruk.ticketapp.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/save")
    public Flight save(@RequestBody Flight flight) {
        return repository.save(flight);
    }

}
