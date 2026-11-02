package com.keyin.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    // Saves a new passenger.
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    // Retrieves all passengers.
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    // Retrieves a passenger by its ID, or returns null if it does not exist.
    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    // Updates an existing passenger's details.
    public Passenger updatePassenger(Long id, Passenger passengerDetails) {
        Passenger passenger = passengerRepository.findById(id).orElse(null);
        if (passenger != null) {
            passenger.setFirstName(passengerDetails.getFirstName());
            passenger.setLastName(passengerDetails.getLastName());
            passenger.setEmail(passengerDetails.getEmail());
            return passengerRepository.save(passenger);
        }
        return null;
    }

    // Deletes the passenger with the given ID.
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    public Page<Passenger> getPassengers(Pageable pageable) {
        return passengerRepository.findAll(pageable);
    }
}
