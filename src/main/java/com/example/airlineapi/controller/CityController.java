package com.example.airlineapi.controller;

import com.example.airlineapi.entity.City;
import com.example.airlineapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CityController {

    @Autowired
    private CityRepository repo;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return (List<City>) repo.findAll();
    }

    @PostMapping("/city")
    public void createCity(@RequestBody City city) {
        repo.save(city);
    }

    @PutMapping("/city/{id}")
    public void updateCity(@PathVariable Long id, @RequestBody City city) {

        Optional<City> returnValue = repo.findById(id);
        City cityToUpdate;

        if (returnValue.isPresent()) {
            cityToUpdate = returnValue.get();

            cityToUpdate.setName(city.getName());
            cityToUpdate.setState(city.getState());
            cityToUpdate.setPopulation(city.getPopulation());

            repo.save(cityToUpdate);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found");
        }
    }
}
