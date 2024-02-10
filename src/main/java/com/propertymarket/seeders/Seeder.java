package com.propertymarket.seeders;

import jakarta.persistence.EntityManager;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Seeder {

    @Autowired
    PropertySeeder propertySeeder;

    public Seeder() {
    }

    /**
     * @return void
     * @desc seeds all classes
    * */
    public void seed() {
        propertySeeder.run();
    }
}
