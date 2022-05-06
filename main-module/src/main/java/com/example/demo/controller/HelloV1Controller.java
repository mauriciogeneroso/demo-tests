package com.example.demo.controller;

import com.example.demo.library.model.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/hello")
public class HelloV1Controller {

    private final Hello hello = new Hello();

    @GetMapping
    public String hello() {
        return hello.getHelloMessage();
    }
}
