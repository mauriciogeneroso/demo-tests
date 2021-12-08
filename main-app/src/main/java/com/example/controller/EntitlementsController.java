package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/entitlements")
public class EntitlementsController {

    @GetMapping
    public String hello() {
        return "Hello Entitlement";
    }
}
