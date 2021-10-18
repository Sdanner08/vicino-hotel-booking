package com.revature.vicino.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.revature.vicino.models.HotelRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import java.io.IOException;


@RestController("bookingController")
public class HotelInfoController{

    Logger log = LoggerFactory.getLogger(HotelInfoController.class);

    @PostMapping()
    public Mono<String> getInfoLL(@RequestBody HotelRequest hotelRequest) throws IOException, UnirestException {
        ///check that values are not empty
        if( hotelRequest.getNumOfRooms() == null || hotelRequest.getNumOfNights()==null || hotelRequest.getAdults()==null ||
            hotelRequest.getLongitude() ==null || hotelRequest.getLatitude()==null || hotelRequest.getCheckinDay()==null ||
            hotelRequest.getCheckinYear()==null || hotelRequest.getCheckinMonth()==null){
            return Mono.just("You must fill out all required fields to receive hotel info.");
        }
        //There is a check for date already
        //If you enter a date before today it'll respond with a "BadRequestException","message":"The checkin time is before today in accommodation {date}


        //Logs the request
        log.info("Request {}", hotelRequest);

        //Makes the request to the API
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

        //Logs the response from API
        log.info("Response {}", response.getBody());

        //Returns the response to the front end
        return Mono.just(response.getBody());
    }

}
