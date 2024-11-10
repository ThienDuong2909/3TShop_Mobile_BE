package com.project._TShop.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project._TShop.Entities.Product;
import com.project._TShop.Entities.Specifications;

public interface SpecificationsRepository extends JpaRepository<Specifications,Integer>{
    List<Specifications> findByProduct(Product product);
    // @Query("SELECT s FROM Specifications s WHERE s.product.product_id = :productId AND s.quantity > :quantity")
    // List<Specifications> findByProductIdAndQuantityGreaterThan(@Param("productId") Integer productId, @Param("quantity") int quantity);
}
