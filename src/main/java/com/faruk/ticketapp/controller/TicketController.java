package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    private TicketRepository repository;

}
