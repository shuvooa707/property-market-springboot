package com.propertymarket.seeders;

import com.propertymarket.model.Company;
import com.propertymarket.service.CompanyService;
import jakarta.persistence.EntityManager;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Seeder {

    @Autowired
    PropertySeeder propertySeeder;
    @Autowired
    UserSeeder userSeeder;
    @Autowired
    ReviewSeeder reviewSeeder;
    @Autowired
    CategorySeeder categorySeeder;
    @Autowired
    ComapnySeeder comapnySeeder;
    @Autowired
    AddressSeeder addressSeeder;

    public Seeder() {
    }

    /**
     * @return void
     * @desc seeds all classes
    * */
    public void seed() {
//        addressSeeder.run();
        comapnySeeder.run();
        categorySeeder.run();
        userSeeder.run();
        propertySeeder.run();
        reviewSeeder.run();
    }
}
