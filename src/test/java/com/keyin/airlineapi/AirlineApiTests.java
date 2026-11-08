package com.keyin.airlineapi;

import com.keyin.airlineapi.aircraft.Aircraft;
import com.keyin.airlineapi.aircraft.AircraftRepository;
import com.keyin.airlineapi.aircraft.AircraftService;
import com.keyin.airlineapi.airport.Airport;
import com.keyin.airlineapi.passenger.Passenger;
import com.keyin.airlineapi.passenger.PassengerRepository;
import com.keyin.airlineapi.passenger.PassengerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AirlineApiTests {

    @Mock
    private PassengerRepository passengerRepository;

    @Mock
    private AircraftRepository aircraftRepository;

    @InjectMocks
    private PassengerService passengerService;

    @InjectMocks
    private AircraftService aircraftService;

    @Test
    void passengerPage() {
        Pageable pageable = PageRequest.of(1, 2, Sort.by(Sort.Direction.DESC, "lastName"));
        Page<Passenger> page = Page.empty(pageable);
        when(passengerRepository.findAll(pageable)).thenReturn(page);

        assertSame(page, passengerService.getPassengers(pageable));
    }

    @Test
    void aircraftPage() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC, "type"));
        Page<Aircraft> page = Page.empty(pageable);
        when(aircraftRepository.findAll(pageable)).thenReturn(page);

        assertSame(page, aircraftService.getAircraft(pageable));
    }

    @Test
    void passengerFound() {
        Passenger passenger = new Passenger();
        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));

        assertSame(passenger, passengerService.getPassengerById(1L));
    }

    @Test
    void passengerMissing() {
        when(passengerRepository.findById(99L)).thenReturn(Optional.empty());

        assertNull(passengerService.getPassengerById(99L));
    }

    @Test
    void aircraftAirports() {
        Airport airport = new Airport();
        Aircraft aircraft = new Aircraft();
        aircraft.setAirports(List.of(airport));
        when(aircraftRepository.findById(1L)).thenReturn(Optional.of(aircraft));

        assertSame(aircraft.getAirports(), aircraftService.getAirportsByAircraftId(1L));
    }
}
