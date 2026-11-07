package com.keyin.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    // Saves a new city.
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    // Retrieves all cities.
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Retrieves a city by its ID, or returns null if it does not exist.
    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    // Updates an existing city's properties while preserving its ID.
    public City updateCity(Long id, City cityDetails) {
        City city = cityRepository.findById(id).orElse(null);
        if (city == null) {
            return null;
        }

        BeanUtils.copyProperties(cityDetails, city, "id", "airports");
        return cityRepository.save(city);
    }

    // Deletes the city with the given ID.
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    // Retrieves the airports in a city, or returns null if the city does not exist.
    public List<Airport> getAirportsByCityId(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        if (city == null) {
            return null;
        }
        return city.getAirports();
    }
}