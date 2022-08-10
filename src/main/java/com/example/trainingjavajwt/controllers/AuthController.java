package com.example.trainingjavajwt.controllers;


import com.example.trainingjavajwt.models.JwtUser;
import com.example.trainingjavajwt.models.LoginDTO;
import com.example.trainingjavajwt.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody LoginDTO loginDTO){
        JwtUser jwtUser;
        jwtUser = getUser(loginDTO);
        if (jwtUser != null){
            return new ResponseEntity<>(jwtGenerator.generate(jwtUser), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    private JwtUser getUser(LoginDTO loginDTO){
        return new JwtUser("1", "eliasr", "Admin");
    }

}
