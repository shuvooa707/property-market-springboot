package com.propertymarket.seeders;

import com.github.javafaker.Faker;
import com.propertymarket.model.Address;
import com.propertymarket.model.Property;
import com.propertymarket.model.Review;
import com.propertymarket.model.User;
import com.propertymarket.repository.AddressRepository;
import com.propertymarket.repository.PropertyRepository;
import com.propertymarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class AddressSeeder {

    @Autowired
    AddressRepository addressRepository;
    /**
     * @desc write your seeding code
     */
    public void run() {
        Faker faker = new Faker();

        IntStream
          .range(0, 9999)
          .parallel()
          .forEach(i -> {
              Address address = new Address();
              address.setState(faker.address().state());
              address.setCity(faker.address().city());
              address.setCountry(faker.address().country());
              address.setStreet(faker.address().streetAddress());
              address.setZip_code((long) (Math.random()*9999));

              addressRepository.save(address);
          });
    }
}
