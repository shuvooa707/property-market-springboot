package com.propertymarket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "roles")
public class Role {
    Role(){

    }
    public Role(Long id, String name){
        this.id = id;
        this.name = name;
    }

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JsonBackReference
    private List<User> users;

}
