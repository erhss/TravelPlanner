package com.shreejan.travel.service;


import com.shreejan.travel.exceptions.TravelException;
import com.shreejan.travel.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TravelService {
    public final TravelRepo travelRepo;

    @Autowired
    public TravelService(TravelRepo travelRepo) {
        this.travelRepo = travelRepo;
    }

    public City addCity(City city){
        return travelRepo.save(city);
    }
    
    public List<City> findAllCity(){
        return travelRepo.findAll();
    }

    public City updateCity(City city){
        return travelRepo.save(city);
    }

    public void deleteCity(String name){
        travelRepo.deleteCityByName(name);
    }

    public City findCityByName(String name) {
        return travelRepo.findCityByName(name).orElseThrow(() -> new TravelException(name + "does not exist"));
    }

}
