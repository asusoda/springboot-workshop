package com.example.soda_workshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Hello {

    // Create the endpoint for the root path
    @GetMapping
    public String hello(){
        return "Hello, World!";
    }

}
