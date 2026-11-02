package com.keyin.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CityController {

    @Autowired
    private CityService cityService;

    // Retrieves all cities.
    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    // Retrieves a city by its ID.
    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    // Creates a new city.
    @PostMapping("/cities")
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    // Updates an existing city.
    @PutMapping("/cities/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    // Deletes the city with the given ID.
    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }

    // Retrieves the airports located in a city.
    @GetMapping("/cities/{id}/airports")
    public List<Airport> getAirportsByCityId(@PathVariable Long id) {
        return cityService.getAirportsByCityId(id);
    }
}