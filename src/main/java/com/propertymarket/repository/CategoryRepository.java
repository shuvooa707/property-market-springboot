package com.propertymarket.repository;

import com.propertymarket.model.Address;
import com.propertymarket.model.Category;
import com.propertymarket.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findBySlug(String slug);

    Category findById(Category category);
}
