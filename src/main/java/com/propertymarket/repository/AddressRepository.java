package com.propertymarket.repository;

import com.propertymarket.model.Address;
import com.propertymarket.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
