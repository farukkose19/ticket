package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.model.Airport;
import com.faruk.ticketapp.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Airport> save(@RequestBody Airport airport)
    {
        try {
            repository.save(airport);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(airport, HttpStatus.OK);
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
