package com.propertymarket.dto;

import com.propertymarket.model.Property;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data
public class CategoryDTO {
    Long id;
    String name;
    String slug;
    private Date CreatedAt;
    private List<Property> properties;
}
