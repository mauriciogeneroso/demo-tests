package com.example.demo.controller;

import com.example.demo.library.model.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloController {

    private Hello hello = new Hello();


    @GetMapping
    public String hello() {
        return hello.getHelloMessage();
    }
}
