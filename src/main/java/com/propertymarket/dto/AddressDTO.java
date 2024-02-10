package com.propertymarket.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class AddressDTO {
    String street;
    String city;
    String state;
    String country;
    Long zip_code;
}
