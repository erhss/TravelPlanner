package com.shreejan.travel;


import com.shreejan.travel.model.City;
import com.shreejan.travel.service.TravelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("api/v1")
public class TravelResource {
    private final TravelService travelService;

    public TravelResource(TravelService travelService) {
        this.travelService = travelService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<City>> getAllCity(){
        List<City> city = travelService.findAllCity();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<City> getCityByName(@PathVariable("name") String name){
        City city = travelService.findCityByName(name);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city){
        City newCity = travelService.addCity(city);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<City> updateCity(@RequestBody City city){
        City updateCity = travelService.updateCity(city);
        return new ResponseEntity<>(updateCity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<City> deleteCity(@PathVariable("name") String name){
        travelService.deleteCity(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
