package com.revature.location.find.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.revature.location.find.model.City;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("locationService")
public class LocationService {


    public City location(String cityName) throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get("https://travel-advisor.p.rapidapi.com/locations/search?query=" + cityName + "&limit=30&offset=0&units=km&location_id=1&currency=USD&sort=relevance&lang=en_US")
                .header("x-rapidapi-host", "travel-advisor.p.rapidapi.com")
                .header("x-rapidapi-key", "49ef9cf13amshcb219f25e45e584p1a7c60jsnced9cf978f2e")
                .asString();

        City city = new City();

        JSONObject obj = new JSONObject(response.getBody());
        JSONArray arr = obj.getJSONArray("data");
        JSONObject o = arr.getJSONObject(0);
        JSONObject o1 = o.getJSONObject("result_object");
        System.out.println(o1.get("location_id"));
        city.setLocationId(Integer.parseInt(o1.get("location_id").toString()));
        return city;
    }

}
