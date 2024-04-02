package com.propertymarket.repository;

import com.propertymarket.model.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Override
    Property save(Property property);


    List<Property> findAllByCategoryId(Long categoryId);

    Page<Property> findByTitleContaining(String propertyName, Pageable pageable);
}
