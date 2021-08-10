package com.example.demo.controllers;

import com.example.demo.services.YelpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YelpRestaurantController {
    private YelpClient client;

    @GetMapping("/restaurant/{name}/{location}")
    public ResponseEntity<String> getRestaurant(@PathVariable String name, @PathVariable String location){
        System.out.println(name + location);
        String response = client.getRestaurantByNameAndLocation(name, location);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Autowired
    public void setClient(YelpClient client) {
        this.client = client;
    }
}
