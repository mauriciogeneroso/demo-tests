package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Hello controller", description = "Short description for the Hello Controller")
@RestController
@RequestMapping(path = "v1/hello")
public class HelloV1Controller {

    @GetMapping
    public String hello() {
        return "Hello world";
    }
}
