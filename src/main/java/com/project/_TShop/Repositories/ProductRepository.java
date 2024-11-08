package com.project._TShop.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project._TShop.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findTop10ByOrderBySoldDesc();

    // @Query("SELECT p FROM Product p ORDER BY p.created_at DESC")
    // List<Product> findTop10ByOrderByCreatedAtDesc();

    @Query(value = "SELECT * FROM Product ORDER BY created_at DESC LIMIT 10", nativeQuery = true)
    List<Product> findTop10ByCreatedAtDescNative();
}
