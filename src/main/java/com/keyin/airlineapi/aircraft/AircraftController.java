package com.keyin.airlineapi.aircraft;

import com.keyin.airlineapi.airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    // Retrieves all aircraft.
    @GetMapping("/aircraft")
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    // Retrieves an aircraft by its ID.
    @GetMapping("/aircraft/{id}")
    public Aircraft getAircraftById(@PathVariable Long id) {
        return aircraftService.getAircraftById(id);
    }

    // Creates a new aircraft.
    @PostMapping("/aircraft")
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.createAircraft(aircraft);
    }

    // Updates an existing aircraft.
    @PutMapping("/aircraft/{id}")
    public Aircraft updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        return aircraftService.updateAircraft(id, aircraft);
    }

    // Deletes the aircraft with the given ID.
    @DeleteMapping("/aircraft/{id}")
    public void deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
    }

    // Retrieves the airports an aircraft takes off from and lands at.
    @GetMapping("/aircraft/{id}/airports")
    public List<Airport> getAirportsByAircraftId(@PathVariable Long id) {
        return aircraftService.getAirportsByAircraftId(id);
    }

    @GetMapping("/aircraft/paged")
    public Page<Aircraft> getAircraft(Pageable pageable) {
        return aircraftService.getAircraft(pageable);
    }
}
