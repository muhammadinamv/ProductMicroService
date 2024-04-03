package com.project.productmicroservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductNotFoundException extends Exception{
    private long id;
    public ProductNotFoundException(String message,long id){
        super(message);
        this.id=id;
    }
}
