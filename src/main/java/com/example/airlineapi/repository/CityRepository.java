package com.example.airlineapi.repository;

import com.example.airlineapi.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    public List<City> findByName(String name);
}
