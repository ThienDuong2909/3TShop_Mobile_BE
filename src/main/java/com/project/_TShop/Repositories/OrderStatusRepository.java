package com.project._TShop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project._TShop.Entities.Order_Status;

public interface OrderStatusRepository extends JpaRepository<Order_Status, Integer>{
    
}
