package com.propertymarket.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity(name = "property_images")
@Data
public class PropertyImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "path")
    private String path;



    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date CreatedAt;


    /*** Relations ***/
    @ManyToOne
    @JsonManagedReference
    private Property property;
}
