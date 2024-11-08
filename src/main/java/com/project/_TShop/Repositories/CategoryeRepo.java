package com.project._TShop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project._TShop.Entities.Category;

public interface CategoryeRepo extends JpaRepository<Category, Integer>{
    
}
