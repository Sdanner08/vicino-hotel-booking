package com.revature.vicino.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.revature.vicino.models.HotelModel;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
public class HotelInfoController{
//    public static void main(String[] args) throws IOException {
//        AsyncHttpClient client = new DefaultAsyncHttpClient();
//        client.prepare("GET", "https://travel-advisor.p.rapidapi.com/hotels/list?location_id=49022&adults=1&rooms=1&nights=2&offset=0&currency=USD&order=asc&limit=30&sort=recommended&lang=en_US")
//                .setHeader("x-rapidapi-host", "travel-advisor.p.rapidapi.com")
//                .setHeader("x-rapidapi-key", "49ef9cf13amshcb219f25e45e584p1a7c60jsnced9cf978f2e")
//                .execute()
//                .toCompletableFuture()
//                .thenAccept(System.out::println)
//                .join();
//
//        client.close();
//    }

/*    public void location() throws IOException{
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.prepare("GET", "https://travel-advisor.p.rapidapi.com/locations/search?query=Waxhaw&limit=30&offset=0&units=km&location_id=1&currency=USD&sort=relevance&lang=en_US")
                .setHeader("x-rapidapi-host", "travel-advisor.p.rapidapi.com")
                .setHeader("x-rapidapi-key", "49ef9cf13amshcb219f25e45e584p1a7c60jsnced9cf978f2e")
                .execute()
                .toCompletableFuture()
                .thenAccept(System.out::println)
                .join();

        client.close();
    }*/

    @PostMapping
    public Mono<String> getHotelInfo(@RequestBody HotelModel hotelModel) throws UnirestException {
        StringBuilder begin = new StringBuilder("https://travel-advisor.p.rapidapi.com/hotels/list-by-latlng?");
        StringBuilder end = new StringBuilder("&lang=en_US&hotel_class=1%2C2%2C3&limit=30");
        //latitude=12.91285&longitude=100.87808
        begin.append("latitude=" + hotelModel.getLat() + "&longitude=" + hotelModel.getLng());
        begin.append(end);
        HttpResponse<String> response = Unirest.get(begin.toString())
                .header("x-rapidapi-host", "travel-advisor.p.rapidapi.com")
                .header("x-rapidapi-key", "49ef9cf13amshcb219f25e45e584p1a7c60jsnced9cf978f2e")
                .asString();


        return Mono.just(response.getBody());
    }
}
