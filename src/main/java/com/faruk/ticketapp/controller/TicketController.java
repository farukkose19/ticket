package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.model.Flight;
import com.faruk.ticketapp.model.Route;
import com.faruk.ticketapp.model.Ticket;
import com.faruk.ticketapp.repository.FlightRepository;
import com.faruk.ticketapp.repository.TicketRepository;
import com.faruk.ticketapp.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    public ResponseEntity<Ticket> save(@RequestBody Ticket ticket) {
        try {
            ticket.setUser(userRepository.findUserById(ticket.getUser().getId()));
            Flight flight = flightRepository.findFlightById(ticket.getFlight().getId());
            ticket.setFlight(flight);
            ticket.setPrice(flight.getFirstPrice());
            repository.save(ticket);
            flight.setSoldSeatNumber(flight.getSoldSeatNumber() + 1);
            for (int i = 9; i > 0; i--) {
                if (flight.getSoldSeatNumber() > flight.getSeatNumbers() * 0.1 * i && flight.getSoldSeatNumber() - 1 <= flight.getSeatNumbers() * 0.1 * i) {
                    flight.setFirstPrice(flight.getFirstPrice() + flight.getFirstPrice() * 0.1);
                    break;
                }
            }
            flightRepository.save(flight);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @RequestMapping("/getTicket")
    public Ticket getTicket(@RequestParam Long id) {
        return repository.findTicketById(id);
    }

    @RequestMapping("/getTicketByTicketNumber")
    public Ticket getTicketByTicketNumber(@RequestParam String ticketNumber) {
        return repository.findTicketByTicketNumber(ticketNumber);
    }

    @RequestMapping("/cancel")
    public ResponseEntity<String> cancel(@RequestParam Long id) {
        try {
            Ticket ticket = repository.findTicketById(id);
            ticket.setStatus(false);
            repository.save(ticket);
            Flight flight = ticket.getFlight();
            flight.setSoldSeatNumber(flight.getSoldSeatNumber() - 1);

            for (int i = 9; i > 0; i--) {
                if (flight.getSoldSeatNumber() <= flight.getSeatNumbers() * 0.1 * i && flight.getSoldSeatNumber() + 1 > flight.getSeatNumbers() * 0.1 * i) {
                    flight.setFirstPrice(flight.getFirstPrice() - flight.getFirstPrice() * 0.1);
                    break;
                }
            }
            flightRepository.save(flight);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("successful", HttpStatus.OK);
    }
}
