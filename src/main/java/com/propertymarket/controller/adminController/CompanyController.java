package com.propertymarket.controller.adminController;


import com.propertymarket.dto.AddressDTO;
import com.propertymarket.dto.CompanyDTO;
import com.propertymarket.dto.PropertyDTO;
import com.propertymarket.model.Address;
import com.propertymarket.model.Company;
import com.propertymarket.model.Property;
import com.propertymarket.repository.CompanyRepository;
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
@RequestMapping("/admin/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyRepository companyRepository;


    Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @GetMapping({"", "/"})
    public String index(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) throws Exception {
        var companyList = companyService.getAllCompanies(page, size);
        int totalPages = companyList.getTotalPages();
        long totalItems = companyList.getTotalElements();
        int currentPage = companyList.getNumber() + 1;


        model.addAttribute("companyList", companyList.getContent());
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pageSize", size);

        return "dashboard/company/index";
    }

    @GetMapping("/create")
    public String create(Model propertyCreateModel) throws Exception {
        return "dashboard/company/create";
    }

    @PostMapping("/create")
    public String store(
      @ModelAttribute CompanyDTO companyDTO,
      @ModelAttribute AddressDTO addressDTO,
      Model model
    ) throws Exception {
        try {
            CustomLogger.writeToFile(companyDTO.toString());
        } catch (Exception exception) {
            CustomLogger.writeToFile(exception.getMessage());
        }

        companyService.save(companyDTO, addressDTO);
        model.addAttribute("status", "success");

        try {
            // save the property
        } catch (Exception exception) {
            model.addAttribute("error", exception.getMessage());
            model.addAttribute("status", "failed");
        }

        return "redirect:/admin/company/";
    }


    /**
     * Show
    * */
    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        Optional<Company> company = companyRepository.findById(id);
        model.addAttribute("company", company.get());
        return "dashboard/company/show";
    }

    /**
     * Edit
     * */
    @GetMapping({"/edit/{id}", "/edit/{id}/"})
    public String edit(@PathVariable("id") long id, Model model) throws Exception {
        Optional<Company> companyOptional = companyRepository.findById(id);
        model.addAttribute("company", companyOptional.get());

        return "dashboard/property/edit";
    }
}
