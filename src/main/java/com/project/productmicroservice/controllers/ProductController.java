package com.project.productmicroservice.controllers;

import com.project.productmicroservice.exceptions.ProductNotFoundException;
import com.project.productmicroservice.models.Product;
import com.project.productmicroservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController{
    private ProductService productService;
    ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        Product product = productService.getProduct(id);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
}
