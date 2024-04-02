package com.propertymarket.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {

    String title;

    String description;

    Double price;

    Integer bedrooms;

    Integer bathrooms;

    Integer balconies;

    Integer garages;

    String location;

    Boolean is_available;

    String company_id;

    String category_id;

    Long sqft;

    MultipartFile thumbnailFile;

    List<MultipartFile> imageFiles;
}
