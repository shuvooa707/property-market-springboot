package com.propertymarket.repository;

import com.propertymarket.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Override
    Property save(Property property);
}
