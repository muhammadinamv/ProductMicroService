package com.project.productmicroservice.services;

import com.project.productmicroservice.exceptions.ProductNotFoundException;
import com.project.productmicroservice.models.Category;
import com.project.productmicroservice.models.Product;
import com.project.productmicroservice.repositories.CategoryRepository;
import com.project.productmicroservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Primary
@Service
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProduct(long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ProductNotFoundException("Product Not Found",id);
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product p) {
        Category category = p.getCategory();
        if(category.getId()==null){
            Category savedCategory = categoryRepository.save(category);
            p.setCategory(savedCategory);
        }
        return productRepository.save(p);
    }
}
