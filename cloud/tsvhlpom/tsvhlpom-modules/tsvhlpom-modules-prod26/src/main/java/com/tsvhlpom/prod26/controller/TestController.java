package com.tsvhlpom.prod26.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/prod26")
    public String prod26(){
        return "prod26";
    }
}
