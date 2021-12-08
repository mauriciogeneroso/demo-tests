package com.example.controller;

import com.example.exception.DownstreamSystemException;
import com.example.exception.GeneralException;
import com.example.exception.InvalidHeaderException;
import com.example.web.exception.ErrorDetail;
import com.example.web.exception.RandomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionsController {

    @GetMapping("/testA")
    public String testA() throws Exception {
        throw new Exception("Exception thrown");
    }

    @GetMapping("/testB")
    public String testB()  {
        throw new InvalidHeaderException("InvalidHeaderException thrown");
    }

    @GetMapping("/testC")
    public String testC()  {
        throw new GeneralException(ErrorDetail.of("OVP_0000", "description for GeneralException", HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/testD")
    public String testD()  {
        throw new DownstreamSystemException(
                ErrorDetail.of("OVP_0000", "description error", HttpStatus.BAD_REQUEST), "description on DownstreamSystemException");
    }

    @GetMapping("/testE")
    public String testE()  {
        throw new RandomException("Random exception");
    }
}
