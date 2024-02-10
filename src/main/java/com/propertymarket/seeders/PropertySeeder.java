package com.propertymarket.seeders;

import com.github.javafaker.Faker;
import com.propertymarket.model.Property;
import com.propertymarket.repository.PropertyRepository;
import com.propertymarket.service.PropertyService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.IntStream;

@Component
public class PropertySeeder {


    public PropertySeeder() {

    }

    @Autowired
    PropertyRepository propertyRepository;

    /**
    * @desc write your seeding code
    * */
    public void run() {
        Faker faker = new Faker();
        IntStream.range(0, 50)
                .forEach(i -> {
                    Property property = new Property();
                    property.setTitle(faker.name().fullName().toString());
                    property.setPrice((double) faker.number().numberBetween(10000,1000000L));
                    property.setSqft(faker.number().numberBetween(400, 5000L));
                    property.setThumbnail("default_property_thumbnail.png");
                    property.setDescription(faker.harryPotter().quote());
                    property.setCreatedAt(new Date());
                    propertyRepository.save(property);
                });
    }
}
