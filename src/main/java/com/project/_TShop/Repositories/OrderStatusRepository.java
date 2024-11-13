package com.project._TShop.Repositories;

import com.project._TShop.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project._TShop.Entities.Order_Status;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderStatusRepository extends JpaRepository<Order_Status, Integer>{

    Optional<List<Order_Status>> findAllByStatus(int status);

    @Query("SELECT o FROM Order_Status o WHERE o.order_id = :order")
    Optional<Order_Status> findByOrder(Order order);

//    @Query("SELECT o FROM Order_Status o WHERE o.order_id = :orderId")
//    Optional<Order_Status> findByOrderId(int orderId);
}
