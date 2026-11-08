package com.keyin.airlineapi.aircraft;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keyin.airlineapi.airport.Airport;
import com.keyin.airlineapi.passenger.Passenger;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String airlineName;
    private int numberOfPassengers;

    @JsonIgnore
    @ManyToMany(mappedBy = "aircraft")
    private List<Passenger> passengers;

    @JsonIgnore
    @ManyToMany
    private List<Airport> airports;

    public Aircraft() {
    }

    public Long getId (){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

}
