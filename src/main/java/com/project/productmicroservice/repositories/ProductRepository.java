package com.project.productmicroservice.repositories;

import com.project.productmicroservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById();

    @Override
    Product save(Product entity);
}
