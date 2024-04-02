package com.propertymarket.seeders;

import com.github.javafaker.Faker;
import com.propertymarket.model.Category;
import com.propertymarket.model.Company;
import com.propertymarket.model.Property;
import com.propertymarket.repository.CategoryRepository;
import com.propertymarket.repository.CompanyRepository;
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
import java.util.List;
import java.util.stream.IntStream;

@Component
public class PropertySeeder {


    public PropertySeeder() {

    }

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CompanyRepository companyRepository;

    /**
     * @desc write your seeding code
     */
    public void run() {
        Faker faker = new Faker();
        List<Category> categories = categoryRepository.findAll();
        List<Company> companies = companyRepository.findAll();

        IntStream
          .range(0, 9999)
          .parallel()
          .forEach(i -> {
              try {
                  int icat = (int)(Math.random() * categories.size());
                  int icom = (int)(Math.random() * companies.size());
                  Property property = new Property();
                  property.setTitle(faker.name().fullName().toString());
                  property.setPrice((double) faker.number().numberBetween(10000, 1000000L));
                  property.setSqft(faker.number().numberBetween(400, 5000L));
                  property.setThumbnail("default_property_thumbnail.png");
                  property.setDescription(faker.harryPotter().quote());
                  property.setCreatedAt(new Date());
                  property.setCategory(categories.get(icat));
                  property.setCompany(companies.get(icom));
                  property.setLocation(faker.address().fullAddress());

                  propertyRepository.save(property);
              } catch (Exception exception) {
                  System.out.println(exception.getMessage());
              }

          });
    }
}
