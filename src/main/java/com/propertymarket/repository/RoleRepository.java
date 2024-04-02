package com.propertymarket.repository;

import com.propertymarket.model.Review;
import com.propertymarket.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Override
    Role save(Role role);

}
