package com.project.productmicroservice.controllers;

import com.project.productmicroservice.models.Product;
import com.project.productmicroservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id){
        return productService.getProduct(id);
    }
    @GetMapping()
    public List<Product> getAllProduct(){
        return new ArrayList<>();
    }
}
