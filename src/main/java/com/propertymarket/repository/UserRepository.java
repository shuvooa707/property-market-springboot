package com.propertymarket.repository;

import com.propertymarket.model.Review;
import com.propertymarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    User save(User user);

}
