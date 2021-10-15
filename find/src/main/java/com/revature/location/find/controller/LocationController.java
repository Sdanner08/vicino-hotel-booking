package com.revature.location.find.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.revature.location.find.model.City;
import com.revature.location.find.service.LocationService;
import org.asynchttpclient.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;
@RestController("locationController")
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping("{cityName}")
    public Mono<City> getLocationId(@PathVariable String cityName) throws IOException, UnirestException {
        City city = this.locationService.location(cityName);
        return Mono.just(city);
    }
}
