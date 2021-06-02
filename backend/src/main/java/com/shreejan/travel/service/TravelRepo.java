package com.shreejan.travel.service;

import com.shreejan.travel.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelRepo extends JpaRepository<City,String> {
    void deleteCityByName(String name);

    Optional<City> findCityByName(String name);
}
