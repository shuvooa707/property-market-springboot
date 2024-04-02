package com.propertymarket.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Controller;

@Data
@Entity(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "rating", columnDefinition = "integer default 0")
    private Integer rating;

    @ManyToOne
    @JsonManagedReference
    private Property property;

    @ManyToOne
    @JsonManagedReference
    private User user;
}
