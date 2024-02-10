package com.propertymarket.repository;

import com.propertymarket.model.Property;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Override
    Property save(Property property);


    List<Property> findAllByCategoryId(Long categoryId);
}
