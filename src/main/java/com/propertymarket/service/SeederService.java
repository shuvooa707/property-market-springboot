package com.propertymarket.service;

import com.propertymarket.model.Property;
import com.propertymarket.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeederService {

    @Autowired
    PropertyRepository propertyRepository;

    public void seed() {
        Property property1 = new Property();
//        propertyRepository.save(property1);
    }
}
