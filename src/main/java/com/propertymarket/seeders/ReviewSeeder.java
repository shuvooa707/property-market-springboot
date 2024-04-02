package com.propertymarket.seeders;

import com.github.javafaker.Faker;
import com.propertymarket.model.*;
import com.propertymarket.repository.CategoryRepository;
import com.propertymarket.repository.PropertyRepository;
import com.propertymarket.repository.ReviewRepository;
import com.propertymarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class ReviewSeeder {


    public ReviewSeeder() {

    }


    @Autowired
    UserRepository userRepository;
    @Autowired
    PropertyRepository propertyRepository;
    @Autowired
    ReviewRepository reviewRepository;
    /**
     * @desc write your seeding code
     */
    public void run() {
        Faker faker = new Faker();
        List<User> users = userRepository.findAll();
        List<Property> properties = propertyRepository.findAll();

        IntStream
          .range(0, 9999)
          .parallel()
          .forEach(i -> {
              User user = users.get( (int)(users.size() * Math.random()) );
              Review review = new Review();
              review.setUser(user);
              review.setContent(faker.howIMetYourMother().catchPhrase());
              review.setRating((int) (Math.random()*5));
              review.setProperty(properties.get((int) (Math.random()*properties.size())));

              reviewRepository.save(review);
          });
    }


    public static Address makeFreshAddress() {
        Faker faker = new Faker();
        Address address = new Address();
        address.setState(faker.address().state());
        address.setCity(faker.address().city());
        address.setCountry(faker.address().country());
        address.setStreet(faker.address().streetAddress());
        address.setZip_code(Long.valueOf(faker.address().zipCode()));

        return address;
    }
}
