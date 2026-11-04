package com.example.airlineapi.controller;

import com.example.airlineapi.entity.Airport;
import com.example.airlineapi.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AirportController {

    @Autowired
    private AirportRepository repo;

    @GetMapping("/airports")
    public List<Airport> getAllAirports() {
        return (List<Airport>) repo.findAll();
    }
}
