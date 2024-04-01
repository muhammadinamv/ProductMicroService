package com.project.productmicroservice.models;

import lombok.Data;

@Data
public class Product {
    private long id;
    private String title;
    private String desc;
    private double price;
    private Category category;
}
