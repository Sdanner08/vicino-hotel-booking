package com.revature.gateway.controller;

//This is if the service goes down and can't be reached. This message will be returned to user.
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("failSafe")
public class FailSafeController {
    @RequestMapping("booking")
    public ResponseEntity<String> bookingServiceDown() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Booking service is currently unavailable. " +
                        "Please check back later!");
    }
}