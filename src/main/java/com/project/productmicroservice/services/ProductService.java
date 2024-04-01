package com.project.productmicroservice.services;

import com.project.productmicroservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(long id);
    List<Product> getAllProducts();
}
