package com.project.productmicroservice.controllers;

import com.project.productmicroservice.dtos.ProductDto;
import com.project.productmicroservice.exceptions.ProductNotFoundException;
import com.project.productmicroservice.models.Product;
import com.project.productmicroservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController{
    private ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product = productService.getProduct(id);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
}
