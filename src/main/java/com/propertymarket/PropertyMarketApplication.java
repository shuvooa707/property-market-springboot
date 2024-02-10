package com.propertymarket;

import com.propertymarket.model.Property;
import com.propertymarket.repository.PropertyRepository;
import com.propertymarket.seeders.PropertySeeder;
import com.propertymarket.seeders.Seeder;
import com.propertymarket.service.SeederService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertyMarketApplication implements CommandLineRunner {

//    @Autowired
//    Seeder seeder;

    public static void main(String[] args) {
        SpringApplication.run(PropertyMarketApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        seeder.seed();
    }
}
