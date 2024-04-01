package com.project.productmicroservice.services;

import com.project.productmicroservice.dtos.FakeStoreProductDTO;
import com.project.productmicroservice.models.Category;
import com.project.productmicroservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{
    @Autowired
    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProduct(long id) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        return buildProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    public Product buildProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDesc(fakeStoreProductDTO.getDesc());

        Category category = new Category();
        category.setId(1);
        category.setDesc(fakeStoreProductDTO.getCategory());

        product.setCategory(category);

        return product;
    }
}
