package com.project.productmicroservice.services;

import com.project.productmicroservice.exceptions.ProductNotFoundException;
import com.project.productmicroservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(long id) throws ProductNotFoundException;
    List<Product> getAllProducts();

    Product addProduct(Product p);
}
