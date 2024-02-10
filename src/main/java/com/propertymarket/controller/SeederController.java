package com.propertymarket.controller;

import com.propertymarket.service.SeederService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeederController {

    @GetMapping("/seed")
    public String seed() {
        SeederService seederService = new SeederService();
        seederService.seed();

        return "seed";
    }
}
