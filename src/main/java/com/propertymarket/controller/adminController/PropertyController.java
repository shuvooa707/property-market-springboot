package com.propertymarket.controller.adminController;


import com.propertymarket.dto.PropertyDTO;
import com.propertymarket.model.Address;
import com.propertymarket.model.Category;
import com.propertymarket.model.Company;
import com.propertymarket.model.Property;
import com.propertymarket.repository.PropertyRepository;
import com.propertymarket.service.*;
import org.hibernate.query.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/property")
public class PropertyController {

    @Autowired
    CompanyService companyService;
    @Autowired
    PropertyService propertyService;
    @Autowired
    AddressService addressService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyRepository propertyRepository;


    //Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @GetMapping({"", "/"})
    public String index(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) throws Exception {
        var propertyList = propertyService.getAllProperties(page, size);
        int totalPages = propertyList.getTotalPages();
        long totalItems = propertyList.getTotalElements();
        int currentPage = propertyList.getNumber() + 1;


        model.addAttribute("propertyList", propertyList.getContent());
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pageSize", size);

        return "dashboard/property/index";
    }

    @GetMapping("/create")
    public String create(Model propertyCreateModel) throws Exception {
        List<Company> companies = companyService
                                    .getAllCompanies();

        List<Address> addresses = addressService
                                    .getAllAddress();

        List<Category> categories = categoryService
                                      .getAllCategories(0, 10)
                                      .getContent();

        propertyCreateModel.addAttribute("companies", companies);
        propertyCreateModel.addAttribute("addresses", addresses);
        propertyCreateModel.addAttribute("categories", categories);

        return "dashboard/property/create";
    }

    @PostMapping({"/create", "/create/"})
    public String store(@ModelAttribute PropertyDTO propertyDTO, Model model) throws Exception {
        try {
            CustomLogger.writeToFile(propertyDTO.toString());
        } catch (Exception exception) {
            CustomLogger.writeToFile(exception.getMessage());
        }

        propertyService.save(propertyDTO);
        model.addAttribute("status", "success");


        return "redirect:/admin/property/";
    }


    /**
     * Show
    * */
    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {

        Optional<Property> property = propertyRepository.findById(id);

        model.addAttribute("property", property.get());
        return "dashboard/property/show";
    }

    /**
     * Edit
     * */
    @GetMapping({"/edit/{id}", "/edit/{id}/"})
    public String edit(@PathVariable("id") long id, Model model) throws Exception {
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        List<Company> companies = companyService.getAllCompanies();
        List<Category> categories = categoryService.getAllCategories();
        List<Address> addresses = addressService.getAllAddress();

        model.addAttribute("property", propertyOptional.get());
        model.addAttribute("companies", companies);
        model.addAttribute("categories", categories);
        model.addAttribute("address", addresses);
        return "dashboard/property/edit";
    }

    /**
     * Update
     * */
    @PostMapping({"/update", "/update/"})
    public String update(@RequestParam("id") long id, @ModelAttribute PropertyDTO propertyDTO) throws Exception {
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        Property property = propertyOptional.get();
        propertyService.updateProperty(property, propertyDTO);
        return "redirect:/admin/property/";
    }

    /**
     * Destroy
     * */
    @PostMapping({"/delete/{id}", "/delete/{id}/"})
    public String destroy(@PathVariable("id") long id) throws Exception {
        propertyRepository.deleteById(id);
        return "redirect:/admin/property/";
    }
}
