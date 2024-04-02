package com.propertymarket.controller.adminController;


import com.propertymarket.dto.PropertyDTO;
import com.propertymarket.model.*;
import com.propertymarket.repository.PropertyRepository;
import com.propertymarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    //Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @GetMapping({"", "/"})
    public String index(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) throws Exception {

        Page<Review> reviews = reviewService.getAllReviews(page, size);
        System.out.println(reviews.getContent());
        int totalPages = reviews.getTotalPages();
        long totalItems = reviews.getTotalElements();
        int currentPage = reviews.getNumber() + 1;


        model.addAttribute("reviews", reviews.getContent());
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pageSize", size);


        return "dashboard/review/index";
    }

    @GetMapping("/create")
    public String create(Model propertyCreateModel) throws Exception {

        return "dashboard/review/create";
    }

    @PostMapping({"/create", "/create/"})
    public String store(@ModelAttribute PropertyDTO propertyDTO, Model model) throws Exception {

        return "redirect:/admin/reviews/";
    }


    /**
     * Show
    * */
    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {

        Review review = reviewService
                          .findById(id)
                          .get();

        model.addAttribute("review", review);

        return "dashboard/review/show";
    }

    /**
     * Edit
     * */
    @GetMapping({"/edit/{id}", "/edit/{id}/"})
    public String edit(@PathVariable("id") long id, Model model) throws Exception {

        return "dashboard/reviews/edit";
    }

    /**
     * Update
     * */
    @PostMapping({"/update", "/update/"})
    public String update(@RequestParam("id") long id, @ModelAttribute PropertyDTO propertyDTO) throws Exception {

        return "redirect:/admin/reviews/";
    }

    /**
     * Destroy
     * */
    @PostMapping({"/delete/{id}", "/delete/{id}/"})
    public String destroy(@PathVariable("id") long id) throws Exception {

        return "redirect:/admin/reviews/";
    }
}
