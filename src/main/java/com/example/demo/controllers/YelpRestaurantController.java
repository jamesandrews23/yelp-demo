package com.example.demo.controllers;

import com.example.demo.models.BusinessResults;
import com.example.demo.services.YelpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/restaurant")
public class YelpRestaurantController {
    private YelpClient client;

    @GetMapping("/nameLocation/{name}/{location}")
    public ResponseEntity<String> getRestaurant(@PathVariable String name, @PathVariable String location){
        String response = client.getRestaurantByNameAndLocation(name, location);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<String> getRestaurantByPhone(@PathVariable String phone){
        BusinessResults response = client.getRestaurantByPhone(phone);
        String reviews = client.getReviewsById(response.getBusinesses().get(0).getId());
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @Autowired
    public void setClient(YelpClient client) {
        this.client = client;
    }
}
