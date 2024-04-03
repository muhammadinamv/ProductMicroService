package com.project.productmicroservice.controllerAdvice;

import com.project.productmicroservice.dtos.ProductNotFoundDto;
import com.project.productmicroservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ProductNotFoundDto productNotFoundDto = new ProductNotFoundDto();
        productNotFoundDto.setMessage("Product Not Found with id "+productNotFoundException.getId());
        return new ResponseEntity<>(productNotFoundDto, HttpStatus.NOT_FOUND);
    }
}