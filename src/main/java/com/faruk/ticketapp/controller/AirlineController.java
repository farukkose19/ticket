package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.model.Airline;
import com.faruk.ticketapp.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/airline")
public class AirlineController {

    @Autowired
    private AirlineRepository repository;

    @RequestMapping("/save")
    public ResponseEntity<Airline> save(@RequestBody Airline airline) {
        try {
            repository.save(airline);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(airline, HttpStatus.OK);
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
