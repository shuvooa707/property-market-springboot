package com.propertymarket.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    Double price;

    @Column(name = "bedrooms")
    Integer bedrooms;

    @Column(name = "bathrooms")
    Integer bathrooms;

    @Column(name = "balconies")
    Integer balconies;

    @Column(name = "garages")
    Integer garages;

    @Column(name = "location")
    String location;

    @Column(name = "is_available")
    Boolean is_available;

    @Column(name = "company_id")
    Long company_id;

    @Column(name = "address_id")
    Long address_id;

    @Column(name = "category_id")
    Long category_id;



    @Column(name = "sqft")
    Long sqft;

    @Column(name = "thumbnail")
    String thumbnail;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date CreatedAt;
}
