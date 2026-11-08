package com.keyin.airlineapi.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class AirportController {

    @Autowired
    private AirportRepository repo;

    @GetMapping("/airports")
    public List<Airport> getAllAirports() {
        return (List<Airport>) repo.findAll();
    }

    @PostMapping("/airport")
    public void createAirport(@RequestBody Airport airport) {
        repo.save(airport);
    }

    @PutMapping("/airport/{id}")
    public void updateAirport(@PathVariable Long id, @RequestBody Airport airport) {

        Optional<Airport> returnValue = repo.findById(id);
        Airport airportToUpdate;

        if (returnValue.isPresent()) {
            airportToUpdate = returnValue.get();

            airportToUpdate.setName(airport.getName());
            airportToUpdate.setCode(airport.getCode());
            airportToUpdate.setCity(airport.getCity());

            repo.save(airportToUpdate);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airport not found");
        }
    }

    @DeleteMapping("/airport/{id}")
    public void deleteAirport(@PathVariable Long id) {

        Optional<Airport> returnValue = repo.findById(id);

        if (returnValue.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airport not found");
        }
    }
}
