package com.propertymarket.service;

import org.springframework.stereotype.Service;

@Service
public class HelperService {

    public void print(String data) {
        System.out.println("\n\n\n");
        System.out.println(data);
        System.out.println("\n\n\n");
    }
}
