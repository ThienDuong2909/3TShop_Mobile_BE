package com.project._TShop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project._TShop.Entities.Cart_Items;

public interface CartItemsRepository extends JpaRepository<Cart_Items, Integer>{
    
}
