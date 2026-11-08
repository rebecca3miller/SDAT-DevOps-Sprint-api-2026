package com.keyin.airlineapi.aircraft;

import com.keyin.airlineapi.airport.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    // Saves a new aircraft.
    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    // Retrieves all aircraft.
    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    // Retrieves an aircraft by its ID, or returns null if it does not exist.
    public Aircraft getAircraftById(Long id) {
        return aircraftRepository.findById(id).orElse(null);
    }

    // Updates an existing aircraft's properties while preserving its ID.
    public Aircraft updateAircraft(Long id, Aircraft aircraftDetails) {
        Aircraft aircraft = aircraftRepository.findById(id).orElse(null);
        if (aircraft == null) {
            return null;
        }

        BeanUtils.copyProperties(aircraftDetails, aircraft, "id", "passengers");
        return aircraftRepository.save(aircraft);
    }

    // Deletes the aircraft with the given ID.
    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }

    // Retrieves the airports an aircraft operates out of, or returns null if it does not exist.
    public List<Airport> getAirportsByAircraftId(Long id) {
        Aircraft aircraft = aircraftRepository.findById(id).orElse(null);
        if (aircraft == null) {
            return null;
        }
        return aircraft.getAirports();
    }

    public Page<Aircraft> getAircraft(Pageable pageable) {
        return aircraftRepository.findAll(pageable);
    }
}
