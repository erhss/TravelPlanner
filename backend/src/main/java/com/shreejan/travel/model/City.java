package com.shreejan.travel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// City model
@Entity
public class City {
    @Id
    @Column(nullable = false)
    private String name;
    private String description;
    private String weather = "cool";

    public City(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }
}
