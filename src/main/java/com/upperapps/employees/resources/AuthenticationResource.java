package com.upperapps.employees.resources;

import com.upperapps.employees.model.Token;
import com.upperapps.employees.model.User;
import com.upperapps.employees.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login", produces = "application/json")
public class AuthenticationResource {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationResource(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<Token> login(@RequestBody User user) {
        
        return ResponseEntity.ok(authenticationService.getToken(user));
    }
}