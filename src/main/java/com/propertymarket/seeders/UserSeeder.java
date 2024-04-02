package com.propertymarket.seeders;

import com.github.javafaker.Faker;
import com.propertymarket.model.Category;
import com.propertymarket.model.Property;
import com.propertymarket.model.Role;
import com.propertymarket.model.User;
import com.propertymarket.repository.CategoryRepository;
import com.propertymarket.repository.PropertyRepository;
import com.propertymarket.repository.RoleRepository;
import com.propertymarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class UserSeeder {


    public UserSeeder() {

    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    /**
     * @desc write your seeding code
     */
    public void run() {
        Faker faker = new Faker();
        roleRepository.save(new Role(1L,"admin"));
        roleRepository.save(new Role(2L,"user"));
        Role role = roleRepository
                      .findById(1L)
                      .get();

        IntStream
          .range(0, 9999)
          .parallel()
          .forEach(i -> {
              User user = new User();
              user.setName(faker.name().fullName());
              user.setImage("images/default_avetar.jpg");
              user.setEmail(faker.internet().emailAddress());
              user.setPhone(faker.phoneNumber().cellPhone());
              user.setAddress(faker.address().fullAddress());
              user.setZip_code((int) (Math.random() * 9999));
              user.setRole(role);
              userRepository.save(user);
          });
    }
}
