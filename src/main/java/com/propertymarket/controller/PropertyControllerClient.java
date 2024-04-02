package com.propertymarket.controller;



import com.propertymarket.model.Category;
import com.propertymarket.model.Property;
import com.propertymarket.service.CategoryService;
import com.propertymarket.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class PropertyControllerClient {

    @Autowired
    PropertyService propertyService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/property/search")
    public String searchProperty(@RequestParam(name = "propertyName") String propertyName, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "20") int size, Model model) throws Exception {

        Page<Property> properties = propertyService.findAllByName(propertyName, page, size);
        List<Category> categories = categoryService.getAllCategories();
//        List<Category> categories = List.of();
        Boolean hasMore = properties.hasNext();

        model.addAttribute("properties", properties.getContent());
        model.addAttribute("hasMore", hasMore);
        model.addAttribute("searchQuery", propertyName);
        model.addAttribute("categories", categories);
        System.out.println( "-------------------------------" );
        System.out.println( properties );
        System.out.println( "-------------------------------" );
        return "property/search";
    }
}
