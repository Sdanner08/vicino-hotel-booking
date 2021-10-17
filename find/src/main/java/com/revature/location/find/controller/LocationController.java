package com.revature.location.find.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.revature.location.find.model.City;
import com.revature.location.find.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

import java.io.IOException;
@RestController("locationController")
public class LocationController {

    Logger log = LoggerFactory.getLogger(LocationController.class);

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping("{cityName}")
    public Mono<City> getLocationId(@PathVariable String cityName) throws IOException, UnirestException {
        ///Add switch statement for common city name searches with their id so Optimize calls to API

        City city = this.locationService.location(cityName);
        Mono.just(city).log();
        return Mono.just(city);
    }

    private ExchangeFilterFunction logRequest(){
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
        log.info("Request {} {} ",clientRequest.method(),clientRequest.url());
        return Mono.just(clientRequest);
        });
    }

    private ExchangeFilterFunction logResponse(){
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            log.info("Response status code {} {} ", clientResponse.statusCode());
            return Mono.just(clientResponse);
        });
    }
}
