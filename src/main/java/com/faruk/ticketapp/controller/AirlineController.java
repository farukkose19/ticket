package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.model.Airline;
import com.faruk.ticketapp.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/airline")
public class AirlineController {

    @Autowired
    private AirlineRepository repository;

    @RequestMapping("/save")
    public Airline save(@RequestBody Airline airline) {
        return repository.save(airline);
    }

    @RequestMapping("/getAll")
    public List<Airline> getAll() {
        return repository.findAll();
    }

    @RequestMapping("/find")
    public List<Airline> find(@RequestParam String name) {
        return repository.findAirlinesByNameStartingWith(name);
    }

}
