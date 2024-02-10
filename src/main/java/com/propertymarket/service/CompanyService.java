package com.propertymarket.service;

import com.propertymarket.dto.AddressDTO;
import com.propertymarket.dto.CompanyDTO;
import com.propertymarket.model.Address;
import com.propertymarket.model.Company;
import com.propertymarket.model.Property;
import com.propertymarket.repository.AddressRepository;
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

    @Autowired
    AddressRepository addressRepository;

    public Page<Company> getAllCompanies(int page, int size) throws Exception {
//        throw new Exception("apple");
//        Pageable pageable = (Pageable) PageRequest.of(0,10);
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findAll(pageable);
    }
    public List<Company> getAllCompanies() throws Exception {;
        return companyRepository.findAll();
    }

    /**
    * Create New Company
    * */
    public void save(CompanyDTO companyDTO, AddressDTO addressDTO) {
        Address newAddress = new Address();

        newAddress.setStreet(addressDTO.getStreet());
        newAddress.setCity(addressDTO.getCity());
        newAddress.setCountry(addressDTO.getCountry());
        newAddress.setState(addressDTO.getState());
        newAddress.setZip_code(addressDTO.getZip_code());

        addressRepository.save(newAddress);

        Company newCompany = new Company();
        newCompany.setTitle(companyDTO.getTitle());
        newCompany.setPhone(companyDTO.getPhone());
        newCompany.setEmail(companyDTO.getEmail());
        newCompany.setPhone(companyDTO.getPhone());
        newCompany.setPhone(companyDTO.getPhone());
        newCompany.setAddress(newAddress);
        companyRepository.save(newCompany);
    }
}
