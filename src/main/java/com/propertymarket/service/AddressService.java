package com.propertymarket.service;

import com.propertymarket.model.Address;
import com.propertymarket.model.Company;
import com.propertymarket.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> getAllAddress() throws Exception {
//        throw new Exception("apple");
//        Pageable pageable = (Pageable) PageRequest.of(0,10);
        return addressRepository.findAll();
    }
}
