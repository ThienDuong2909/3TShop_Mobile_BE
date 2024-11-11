package com.project._TShop.Repositories;

import com.project._TShop.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project._TShop.Entities.Order_Status;

import java.util.List;
import java.util.Optional;

public interface OrderStatusRepository extends JpaRepository<Order_Status, Integer>{

    Optional<List<Order_Status>> findAllByStatus(int status);


}
