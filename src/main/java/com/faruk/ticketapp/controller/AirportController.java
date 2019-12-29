package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.model.Airport;
import com.faruk.ticketapp.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/airport")
public class AirportController {

    @Autowired
    private AirportRepository repository;

    @RequestMapping("/save")
    public Airport save(@RequestBody Airport airport) {
        return repository.save(airport);
    }

    @RequestMapping("/getAll")
    public List<Airport> getAll() {
        return repository.findAll();
    }

    @RequestMapping("/find")
    public List<Airport> find(@RequestParam String name) {
        return repository.findAirportsByNameStartingWith(name);
    }
}
