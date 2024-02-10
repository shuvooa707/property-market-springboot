package com.propertymarket.repository;

import com.propertymarket.model.Property;
import com.propertymarket.model.PropertyImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyImageRepository extends JpaRepository<PropertyImage, Long> {

    @Override
    PropertyImage save(PropertyImage propertyImage);
}
