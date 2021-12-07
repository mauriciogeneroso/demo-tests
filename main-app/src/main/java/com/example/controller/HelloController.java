package com.example.controller;

import com.example.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloController {

    @Autowired
    private ConfigProperties ConfigProperties;

    @GetMapping
    public String hello() {
        return "Hello";
    }
}
