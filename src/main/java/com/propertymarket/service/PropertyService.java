package com.propertymarket.service;

import com.propertymarket.dto.PropertyDTO;
import com.propertymarket.model.Category;
import com.propertymarket.model.Property;
import com.propertymarket.model.PropertyImage;
import com.propertymarket.repository.CategoryRepository;
import com.propertymarket.repository.PropertyImageRepository;
import com.propertymarket.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PropertyImageRepository propertyImageRepository;

    @Autowired
    FileService fileService;

    public Page<Property> getAllProperties(int page, int size) throws Exception {
        Pageable pageable = PageRequest.of(page, size);
        return propertyRepository.findAll(pageable);
    }

    public void save(PropertyDTO propertyDTO) throws IOException {
        String thumbnailFilePath = fileService.saveFileToDisk(propertyDTO.getThumbnailFile());
        List<String> imageFilePaths = propertyDTO
                                        .getImageFiles()
                                        .stream()
                                        .map(file -> {
                                            try {
                                                return fileService.saveFileToDisk(file);
                                            } catch (IOException e) {
                                                throw new RuntimeException(e);
                                            }
                                        })
                                        .toList();

        // saving the property
        Property newProperty = new Property();
        newProperty.setTitle(propertyDTO.getTitle());
        newProperty.setDescription(propertyDTO.getDescription());
        newProperty.setThumbnail(thumbnailFilePath);
        newProperty.setPrice(propertyDTO.getPrice());
        newProperty.setSqft(propertyDTO.getSqft());
        newProperty.setBedrooms(propertyDTO.getBedrooms());
        newProperty.setBalconies(propertyDTO.getBalconies());
        newProperty.setBathrooms(propertyDTO.getBathrooms());
        newProperty.setGarages(propertyDTO.getGarages());
        newProperty.setLocation(propertyDTO.getLocation());
        newProperty.setIs_available(propertyDTO.getIs_available());

        Optional<Category> newlyCreatedCategory = categoryRepository.findById(Long.valueOf(propertyDTO.getCategory_id()));

        newProperty.setCategory(newlyCreatedCategory.get());

        Property newlyCreatedProperty = propertyRepository.save(newProperty);

        imageFilePaths
          .stream()
          .forEach(imageFilePath -> {
              PropertyImage propertyImage = new PropertyImage();
              propertyImage.setPath(imageFilePath);
              propertyImage.setProperty_id(newlyCreatedProperty.getId());
              propertyImageRepository.save(propertyImage);
          });
    }

    public void updateProperty(Property property, PropertyDTO propertyDTO) {
//        property.setCompany_id(Long.valueOf(propertyDTO.getCompany_id()));
//        property.setCategory_id(Long.valueOf(propertyDTO.getCategory_id()));
        property.setBalconies(propertyDTO.getBalconies());
        property.setBedrooms(propertyDTO.getBedrooms());
        property.setGarages(propertyDTO.getGarages());
        property.setSqft(propertyDTO.getSqft());
        property.setPrice((propertyDTO.getPrice()));
        property.setDescription((propertyDTO.getDescription()));
        property.setLocation((propertyDTO.getLocation()));
        property.setIs_available((propertyDTO.getIs_available()));
        property.setTitle((propertyDTO.getTitle()));

        propertyRepository.save(property);
    }

    public Optional<Property> findById(long id) {
        return propertyRepository.findById(id);
    }

    public List<Property> findAllByCategoryId(Long categoryId) {

        return propertyRepository.findAllByCategoryId(categoryId);
    }
}
