package com.propertymarket.controller.adminController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.propertymarket.seeders.Seeder;
import com.propertymarket.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class HelperController {

    @Autowired
    Seeder seeder;
    @Autowired
    PropertyService propertyService;

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping({"/admin/seed", "/admin/seed/"})
    public String seed() {
        seeder.seed();

        return "redirect:/admin/property/";
    }


    @GetMapping("/routes")
    public Map<String, String> getAllRoutes(RequestMappingHandlerMapping requestMappingHandlerMapping) throws JsonProcessingException {
        Map<String, String> routes = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();
        routes.put("_", objectMapper.writeValueAsString(propertyService));



        return routes;
    }
}
