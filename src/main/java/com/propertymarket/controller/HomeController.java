package com.propertymarket.controller;

import com.propertymarket.model.Category;
import com.propertymarket.model.Property;
import com.propertymarket.repository.CategoryRepository;
import com.propertymarket.service.CategoryService;
import com.propertymarket.service.PropertyService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    PropertyService propertyService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
        try {
            List<Property> propertyList = propertyService.getAllProperties(page, size).getContent();
            List<Category> categories =  categoryService.getAllCategories();
            model.addAttribute("properties", propertyList);
            model.addAttribute("categories", categories);
            model.addAttribute("error", null);
        } catch (Exception exception) {
            model.addAttribute("error", exception.getMessage());
        }

        return "property/index";
    }
    @GetMapping("/property/{id}")
    public String property(@PathVariable(name = "id") long id, Model model) throws Exception {
        Optional<Property> property = propertyService.findById(id);
        List<Category> categories =  categoryService.getAllCategories();

        model.addAttribute("property", property.get());
        model.addAttribute("categories", categories);
        return "property/show";
    }
    @GetMapping("/property/category/{slug}")
    public String property(@PathVariable(name = "slug") String slug, Model model) throws Exception {
        Optional<Category> category = categoryService.findBySlug(slug);
        List<Property> properties = propertyService.findAllByCategoryId(category.get().getId());
        List<Category> categories =  categoryService.getAllCategories();

        model.addAttribute("properties", properties);
        model.addAttribute("slug", slug);
        model.addAttribute("categories", categories);
        model.addAttribute("category", category.get());

        return "property/index";
    }
}
