package com.faruk.ticketapp.controller;

import com.faruk.ticketapp.model.User;
import com.faruk.ticketapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/save")
    public User save(@RequestBody User user) {
        return repository.save(user);
    }

}
