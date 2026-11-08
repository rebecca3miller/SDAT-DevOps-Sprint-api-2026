package com.keyin.airlineapi.passenger;

import com.keyin.airlineapi.aircraft.Aircraft;
import com.keyin.airlineapi.airport.Airport;
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
            passenger.setPhoneNumber(passengerDetails.getPhoneNumber());
            if (passengerDetails.getCity() != null) {
                passenger.setCity(passengerDetails.getCity());
            }
            if (passengerDetails.getAircraft() != null) {
                passenger.setAircraft(passengerDetails.getAircraft());
            }
            return passengerRepository.save(passenger);
        }
        return null;
    }

    // Deletes the passenger with the given ID.
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    // Retrieves the aircraft a passenger has flown on, or returns null if the passenger does not exist.
    public List<Aircraft> getAircraftByPassengerId(Long id) {
        Passenger passenger = passengerRepository.findById(id).orElse(null);
        if (passenger == null) {
            return null;
        }
        return passenger.getAircraft();
    }

    // Retrieves the distinct airports served by aircraft that passengers have flown on.
    public List<Airport> getAirportsUsedByPassengers() {
        return passengerRepository.findAll().stream()
                .filter(passenger -> passenger.getAircraft() != null)
                .flatMap(passenger -> passenger.getAircraft().stream())
                .filter(aircraft -> aircraft.getAirports() != null)
                .flatMap(aircraft -> aircraft.getAirports().stream())
                .distinct()
                .toList();
    }

    public Page<Passenger> getPassengers(Pageable pageable) {
        return passengerRepository.findAll(pageable);
    }
}
