package com.propertymarket.repository;

import com.propertymarket.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Override
    Company save(Company company);
}
