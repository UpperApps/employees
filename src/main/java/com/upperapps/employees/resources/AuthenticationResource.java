package com.upperapps.employees.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login", produces = "application/json")
public class AuthenticationResource {

    @GetMapping
    public String login() {
        return "Tá logado!";
    }
}