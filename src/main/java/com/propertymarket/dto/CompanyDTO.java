package com.propertymarket.dto;

import com.propertymarket.model.Property;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    Long id;

    @Column(name = "name")
    String title;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

}
