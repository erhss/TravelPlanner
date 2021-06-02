package com.shreejan.travel.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shreejan.travel.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@EnableScheduling
public class Weather {
    public final TravelRepo travelRepo;

    @Autowired
    public Weather(TravelRepo travelRepo) {
        this.travelRepo = travelRepo;
    }

    @Scheduled(fixedRate = 900000)
    public void addWeatherOfCity(){
        RestTemplate restTemplate = new RestTemplate();
        Gson gson = new GsonBuilder().create();
        List<City> cityList = travelRepo.findAll();
        for (City city : cityList) {
            final String uri = "http://api.openweathermap.org/data/2.5/weather?q=" + city.getName() + "&APPID=07d853da85316085eca5c39ed82707f3";
                String result = restTemplate.getForObject(uri, String.class);
                JsonObject job = gson.fromJson(result, JsonObject.class);
                JsonElement entry = job.getAsJsonObject("main").get("temp");
                JsonElement entry2 = job.getAsJsonArray("weather").get(0).getAsJsonObject().get("main");
                int weatherInt = entry.getAsInt();
                weatherInt -= 273; // kelvin to Celsius
                String weather = "The weather is " + entry2.toString() + " and it is " + weatherInt + " degrees celsius";
                city.setWeather(weather);
                travelRepo.save(city);
        }
    }
}
