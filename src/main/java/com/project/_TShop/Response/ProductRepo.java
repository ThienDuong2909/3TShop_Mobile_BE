package com.project._TShop.Response;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project._TShop.Entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
    
}
