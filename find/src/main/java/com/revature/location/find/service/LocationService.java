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
/*        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.prepare("GET", "https://travel-advisor.p.rapidapi.com/locations/search?query=" + cityName + "&limit=30&offset=0&units=km&location_id=1&currency=USD&sort=relevance&lang=en_US")
                .setHeader("x-rapidapi-host", "travel-advisor.p.rapidapi.com")
                .setHeader("x-rapidapi-key", "49ef9cf13amshcb219f25e45e584p1a7c60jsnced9cf978f2e")
                .execute()
                .toCompletableFuture()
                .thenAccept(System.out::println)
                .join();

        client.close();*/
        HttpResponse<String> response = Unirest.get("https://travel-advisor.p.rapidapi.com/locations/v2/auto-complete?query="+ cityName+"&lang=en_US&units=km")
                .header("x-rapidapi-host", "travel-advisor.p.rapidapi.com")
                .header("x-rapidapi-key", "a3582833c4mshe7ab93b1542c50bp186450jsn34d6409641ab")
                .asString();
       // System.out.println(response);
        City city = new City();

        //JSONObject obj = new JSONObject(response.getBody());

      //  System.out.println(response.getBody());
        //System.out.println(obj);
        //JSONArray arr = obj.getJSONArray("data");

      //  System.out.println(arr.toString());
        //for (int i = 0; i < arr.length(); i++) {
            //JSONObject o = arr.getJSONObject(i);
          //  System.out.println(arr.length() + "    " + o);
        //}

        /*Integer cityLocationId = response.getBody().getObject();*/
/*        city.setLocationId(1);
        System.out.println(city);
        JSONObject obj = new JSONObject(response.getBody());
        System.out.println(obj.getString("locationId"));
        System.out.println(obj.get("locationId"));*/
/*         String x=   response.getBody();
         String loca = x.("locationId");
        System.out.println(loca);locationId" : 34438,
        System.out.println(x);*/

       // "data" : { "Typeahead_autocomplete" : { "results" : [ { "detailsV2" : { "locationId" : 34438,

        JSONObject obj = new JSONObject(response.getBody());

        JSONArray arr = obj.getJSONArray("data");

        JSONObject o = arr.getJSONObject(0);

        JSONObject o1 = o.getJSONObject("result_object");

        System.out.println(o1.get("location_id"));

        city.setLocationId(Integer.parseInt(o1.get("location_id").toString()));

        return city;
    }

}
