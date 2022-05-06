package com.example.demo.controller;

import com.example.demo.library.model.Hello;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Hello controller", description = "Short description for the Hello Controller")
@RestController
@RequestMapping(path = "v1/hello")
public class HelloV1Controller {

    private final Hello hello = new Hello();

    @GetMapping
    public String hello() {
        return hello.getHelloMessage();
    }
}
