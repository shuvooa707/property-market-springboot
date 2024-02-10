package com.propertymarket.service;

import com.propertymarket.dto.CategoryDTO;
import com.propertymarket.model.Category;
import com.propertymarket.model.Property;
import com.propertymarket.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Page<Category> getAllCategories(int page, int size) throws Exception {
        Pageable pageable = PageRequest.of(page, size);
        return categoryRepository.findAll(pageable);
    }
    public List<Category> getAllCategories() throws Exception {
        return categoryRepository.findAll();
    }


    public void save(CategoryDTO categoryDTO) throws Exception {
        Category category = new Category();
        // create slug out of name
        String name = categoryDTO.getName();
        String slug = Arrays.stream(name.split(" ")).collect(Collectors.joining("-"));
        category.setName(categoryDTO.getName());
        category.setSlug(slug);
        categoryRepository.save(category);
    }

    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }


    public Optional<Category> findBySlug(String slug) {
        return categoryRepository.findBySlug(slug);
    }
}
