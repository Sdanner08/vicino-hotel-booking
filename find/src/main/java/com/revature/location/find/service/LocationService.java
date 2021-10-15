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
        HttpResponse<String> response = Unirest.get("https://travel-advisor.p.rapidapi.com/locations/v2/auto-complete?query="+ cityName+"&lang=en_US&units=km")
                .header("x-rapidapi-host", "travel-advisor.p.rapidapi.com")
                .header("x-rapidapi-key", "a3582833c4mshe7ab93b1542c50bp186450jsn34d6409641ab")
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
