package com.propertymarket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "title")
    @NotNull
    String title;

    @Lob
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


    @Column(name = "sqft")
    Long sqft;

    @Column(name = "thumbnail")
    String thumbnail;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date CreatedAt;


    @ManyToOne
    @JsonManagedReference
    private Category category;

    @ManyToOne
    private Company company;

    @OneToMany
    @JsonBackReference
    private List<Review> reviews;

    @OneToMany(mappedBy = "property")
    @JsonBackReference
    private List<PropertyImage> images;
}
