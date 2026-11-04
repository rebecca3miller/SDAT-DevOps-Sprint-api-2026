package com.keyin.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    // Retrieves all passengers.
    @GetMapping("/passengers")
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    // Retrieves the airports used by passengers.
    @GetMapping("/passengers/airports")
    public List<Airport> getAirportsUsedByPassengers() {
        return passengerService.getAirportsUsedByPassengers();
    }

    // Retrieves a passenger by its ID.
    @GetMapping("/passengers/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {
        return passengerService.getPassengerById(id);
    }

    // Creates a new passenger.
    @PostMapping("/passengers")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    // Updates an existing passenger.
    @PutMapping("/passengers/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        return passengerService.updatePassenger(id, passenger);
    }

    // Deletes the passenger with the given ID.
    @DeleteMapping("/passengers/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }

    // Retrieves the aircraft a passenger has flown on.
    @GetMapping("/passengers/{id}/aircraft")
    public List<Aircraft> getAircraftByPassengerId(@PathVariable Long id) {
        return passengerService.getAircraftByPassengerId(id);
    }

    @GetMapping("/passengers/paged")
    public Page<Passenger> getPassengers(Pageable pageable) {
        return passengerService.getPassengers(pageable);
    }
}
