package com.propertymarket.seeders;

import com.github.javafaker.Faker;
import com.propertymarket.model.*;
import com.propertymarket.repository.AddressRepository;
import com.propertymarket.repository.CompanyRepository;
import com.propertymarket.repository.PropertyRepository;
import com.propertymarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class ComapnySeeder {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    AddressRepository addressRepository;


    /**
     * @desc write your seeding code
     */
    public void run() {
        Faker faker = new Faker();

        IntStream
          .range(0, 999)
          .parallel()
          .forEach(i -> {
              try {

                  Address address = new Address();
                  address.setStreet(faker.address().streetAddress());
                  address.setCity(faker.address().city());
                  address.setState(faker.address().state());
                  address.setCountry(faker.address().country());
                  address.setZip_code((long) (Math.random() * 9999));

                  addressRepository.save(address);

                  Company company = new Company();
                  company.setTitle(faker.company().name());
                  company.setPhone(faker.phoneNumber().cellPhone());
                  company.setEmail(faker.internet().emailAddress());
                  company.setAddress(address);

                  companyRepository.save(company);
              } catch (Exception exception) {
                  System.out.println(exception.getMessage());
              }
          });
    }
}
