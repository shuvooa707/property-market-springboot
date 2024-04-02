package com.propertymarket.service;

import com.propertymarket.dto.AddressDTO;
import com.propertymarket.dto.CompanyDTO;
import com.propertymarket.model.Address;
import com.propertymarket.model.Company;
import com.propertymarket.model.Review;
import com.propertymarket.repository.AddressRepository;
import com.propertymarket.repository.CompanyRepository;
import com.propertymarket.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;


    public Page<Review> getAllReviews(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return reviewRepository.findAll(pageable);
    }
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }


    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }
}
