package com.propertymarket.repository;

import com.propertymarket.model.Address;
import com.propertymarket.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Override
    Address save(Address address);
}
