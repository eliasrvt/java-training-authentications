package com.example.trainingjavajwt.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/movements")
public class MovementsController {


    @GetMapping()
    public ResponseEntity<?> getMovements(){
        return new ResponseEntity<>("Body", HttpStatus.ACCEPTED);
    }
}
