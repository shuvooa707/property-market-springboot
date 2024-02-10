package com.propertymarket.controller.adminController;


import com.propertymarket.dto.CategoryDTO;
import com.propertymarket.dto.PropertyDTO;
import com.propertymarket.model.Address;
import com.propertymarket.model.Category;
import com.propertymarket.model.Company;
import com.propertymarket.model.Property;
import com.propertymarket.repository.CategoryRepository;
import com.propertymarket.repository.PropertyRepository;
import com.propertymarket.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    CompanyService companyService;

    @Autowired
    PropertyService propertyService;
    @Autowired
    AddressService addressService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;


    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping({"", "/"})
    public String index(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) throws Exception {
        var categoryList = categoryService.getAllCategories(page, size);
        int totalPages = categoryList.getTotalPages();
        long totalItems = categoryList.getTotalElements();
        int currentPage = categoryList.getNumber() + 1;


        model.addAttribute("categoryList", categoryList.getContent());
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pageSize", size);

        return "dashboard/category/index";
    }

    @GetMapping("/create")
    public String create() throws Exception {

        return "dashboard/category/create";
    }

    @PostMapping("/create")
    public String store(@ModelAttribute CategoryDTO categoryDTO, Model model) throws Exception {
        try {
            CustomLogger.writeToFile(categoryDTO.toString());
        } catch (Exception exception) {
            CustomLogger.writeToFile(exception.getMessage());
        }

        categoryService.save(categoryDTO);
        model.addAttribute("status", "success");
        try {
            // save the property
        } catch (Exception exception) {
            model.addAttribute("error", exception.getMessage());
            model.addAttribute("status", "failed");
        }

        return "redirect:/admin/category/";
    }


    /**
     * Show
    * */
    @GetMapping({"/{id}", "/{id}/"})
    public String show(@PathVariable("id") long id, Model model) {

        Optional<Category> category = categoryService.findById(id);

        model.addAttribute("category", category.get());
        return "dashboard/category/show";
    }

    /**
     * Edit
     * */
    @GetMapping({"/edit/{id}", "/edit/{id}/"})
    public String edit(@PathVariable("id") long id, Model model) throws Exception {

        return "dashboard/property/edit";
    }


    /**
     * Edit
     * */
    @GetMapping({"/destroy/{id}", "/destroy/{id}/"})
    public String destroy(@PathVariable("id") long id) throws Exception {

        return "dashboard/category";
    }
}
