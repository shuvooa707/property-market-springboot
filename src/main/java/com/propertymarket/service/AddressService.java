package com.propertymarket.service;

import com.propertymarket.model.Company;
import com.propertymarket.model.Property;
import com.propertymarket.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompanies() throws Exception {
//        throw new Exception("apple");
//        Pageable pageable = (Pageable) PageRequest.of(0,10);
        return companyRepository.findAll();
    }
}
