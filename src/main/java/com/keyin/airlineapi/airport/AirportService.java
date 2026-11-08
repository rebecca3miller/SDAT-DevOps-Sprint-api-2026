package com.keyin.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    // Saves a new airport.
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    // Retrieves all airports.
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    // Retrieves an airport by its ID, or returns null if it does not exist.
    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    // Updates an existing airport's properties while preserving its ID.
    public Airport updateAirport(Long id, Airport airportDetails) {
        Airport airport = airportRepository.findById(id).orElse(null);
        if (airport == null) {
            return null;
        }

        BeanUtils.copyProperties(airportDetails, airport, "id", "aircraft");
        return airportRepository.save(airport);
    }

    // Deletes the airport with the given ID.
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
