package com.project.productmicroservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private double price;
    @ManyToOne
    private Category category;
}
