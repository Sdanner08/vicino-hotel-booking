package com.revature.vicino.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.revature.vicino.VicinoApplication;
import com.revature.vicino.models.HotelRequest;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController("bookingController")
public class HotelInfoController{

    Logger log = LoggerFactory.getLogger(HotelInfoController.class);
/*    @PostMapping
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
    }*/

    @PostMapping
    public Mono<String> getInfoLL(@RequestBody HotelRequest hotelRequest) throws IOException, UnirestException {
        ///check that values are not empty
        log.info("Request {}", hotelRequest);
        HttpResponse<String> response = Unirest.get("https://travel-advisor.p.rapidapi.com/hotels/list-by-latlng?latitude="
                +hotelRequest.getLatitude()+
                "&longitude="+hotelRequest.getLongitude()+"&lang=en_US&hotel_class=1%2C2%2C3&limit=30&" +
                "adults="+hotelRequest.getAdults()+
                "1&amenities=beach%2Cbar_lounge%2Cairport_transportation&rooms="+hotelRequest.getNumOfRooms()+
                "&child_rm_ages=7%2C10&currency=USD&" +
                "checkin="+hotelRequest.getCheckinYear()+"-"+hotelRequest.getCheckinMonth()+"-"+hotelRequest.getCheckinDay()+
                "&zff=4%2C6&subcategory=hotel%2Cbb%2Cspecialty&" +
                "nights="+hotelRequest.getNumOfNights())

                .header("x-rapidapi-host", "travel-advisor.p.rapidapi.com")
                .header("x-rapidapi-key", "a3582833c4mshe7ab93b1542c50bp186450jsn34d6409641ab")
                .asString();
        log.info("Response {}", response.getBody());
        return Mono.just(response.getBody());
    }

/*    private ExchangeFilterFunction logRequest(HotelRequest hotelRequest){
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("Request {} {}",clientRequest.method(),clientRequest.httpRequest());
            return Mono.just(clientRequest);
        });
    }
    private ExchangeFilterFunction logResponse(HttpResponse<String> response){
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            log.info("Response status code {} {}",clientResponse.statusCode(),Mono.just(clientResponse));
            return Mono.just(clientResponse);
        });
    }*/

}
