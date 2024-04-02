package com.propertymarket.seeders;

import com.github.javafaker.Faker;
import com.propertymarket.model.Category;
import com.propertymarket.model.Property;
import com.propertymarket.model.Review;
import com.propertymarket.model.User;
import com.propertymarket.repository.CategoryRepository;
import com.propertymarket.repository.PropertyRepository;
import com.propertymarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class CategorySeeder {


    public CategorySeeder() {

    }


    @Autowired
    CategoryRepository categoryRepository;

    /**
     * @desc write your seeding code
     */
    public void run() {
        Faker faker = new Faker();
        List<Category> categories = categoryRepository.findAll();

        IntStream
          .range(0, 9999)
          .parallel()
          .forEach(i -> {
              Category category = new Category();
              category.setName(faker.animal().name());
              category.setSlug(category.getName().replaceAll(" ", "-"));

              categoryRepository.save(category);
          });
    }
}
