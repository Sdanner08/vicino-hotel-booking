package com.revature.vicino.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.revature.vicino.models.HotelRequest;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
public class HotelInfoController{
    @PostMapping
    public Mono<String> getInfo(@RequestBody HotelRequest hotelRequest) throws IOException, UnirestException {
        StringBuilder beginning = new StringBuilder("https://travel-advisor.p.rapidapi.com/hotels/list?location_id=");
        StringBuilder end = new StringBuilder("&offset=0&currency=USD&order=asc&limit=30&sort=recommended&lang=en_US");

        beginning.append(hotelRequest.getLocationId().toString());

        if (hotelRequest.getAdults() != null) {
            beginning.append("&" + hotelRequest.getAdults().toString());
        }
        if (hotelRequest.getNumOfRooms() != null) {
            beginning.append("&" + hotelRequest.getNumOfRooms().toString());
        }
        if (hotelRequest.getNumOfNights() != null) {
            beginning.append("&" + hotelRequest.getNumOfNights().toString());
        }

        beginning.append(end);

        HttpResponse<String> response = Unirest.get(beginning.toString())
                .header("x-rapidapi-host", "travel-advisor.p.rapidapi.com")
                .header("x-rapidapi-key", "49ef9cf13amshcb219f25e45e584p1a7c60jsnced9cf978f2e")
                .asString();

        return Mono.just(response.getBody());
    }
}
