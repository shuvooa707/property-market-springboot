package com.propertymarket.response.properties;

import com.propertymarket.model.Property;
import lombok.Data;

import java.util.List;

@Data
public class ScrollMorePropertiesResponse {
    public String status = "success";
    List<Property> properties;
    public ScrollMorePropertiesResponse(String status, List<Property> properties) {
        this.status = status;
        this.properties = properties;
    }
}
