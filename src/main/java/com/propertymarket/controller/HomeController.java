package com.propertymarket.controller;

import com.propertymarket.model.Category;
import com.propertymarket.model.Property;
import com.propertymarket.model.Review;
import com.propertymarket.model.User;
import com.propertymarket.repository.ReviewRepository;
import com.propertymarket.response.properties.ScrollMorePropertiesResponse;
import com.propertymarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    PropertyService propertyService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    HelperService helperService;

    @GetMapping("/")
    public String home(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "33") int size) throws Exception {

        try {
            List<Property> properties = propertyService
                                          .getAllProperties(page, size)
                                          .getContent();

            List<Category> categories = categoryService
                                          .getAllCategories(0, 15)
                                          .getContent();

            List<Review> reviews = reviewService
                                     .getAllReviews(0, 10)
                                     .getContent();

            /** Soft The category list  **/
            categories = categories
                           .stream()
                           .sorted((Category left, Category right) -> right.getProperties().size() - left.getProperties().size())
                           .collect(Collectors.toList());



            model.addAttribute("properties", properties);
            model.addAttribute("categories", categories);
            model.addAttribute("reviews", reviews);
            model.addAttribute("error", null);


        } catch (Exception exception) {
            model.addAttribute("error", exception.getMessage());
        }


        return "property/index";
    }

    @GetMapping("/scroll-more")
    @ResponseBody
    public ScrollMorePropertiesResponse scrollMoreProperty(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "33") int size) throws Exception {
        List<Property> properties = propertyService.getAllProperties(page, size).getContent();

        return new ScrollMorePropertiesResponse("success", properties);
    }


    @GetMapping("/property/{id}")
    public String property(@PathVariable(name = "id") long id, Model model) throws Exception {
        Property property = propertyService.findById(id).get();
        List<Category> categories = categoryService.getAllCategories();

        model.addAttribute("property", property);
        model.addAttribute("categories", categories);


        return "property/show";
    }


    @GetMapping("/property/category/{slug}")
    public String property(@PathVariable(name = "slug") String slug, Model model) throws Exception {
        Optional<Category> category = categoryService.findBySlug(slug);
        List<Property> properties = propertyService.findAllByCategoryId(category.get().getId());
        List<Category> categories = categoryService.getAllCategories();

        /** Soft The category list  **/
        categories = categories
                       .stream()
                       .sorted((Category left, Category right) -> right.getProperties().size() - left.getProperties().size())
                       .collect(Collectors.toList());

        model.addAttribute("properties", properties);
        model.addAttribute("slug", slug);
        model.addAttribute("categories", categories);
        model.addAttribute("category", category.get());

        return "property/byCategory";
    }



}
