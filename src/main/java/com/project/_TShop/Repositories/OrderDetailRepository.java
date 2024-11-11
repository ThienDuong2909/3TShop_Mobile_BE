package com.project._TShop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project._TShop.Entities.Order_Detail;

public interface OrderDetailRepository extends JpaRepository<Order_Detail, Integer>{
    
}
