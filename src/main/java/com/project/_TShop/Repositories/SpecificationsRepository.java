package com.project._TShop.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project._TShop.Entities.Color;
import com.project._TShop.Entities.Product;
import com.project._TShop.Entities.Size;
import com.project._TShop.Entities.Specifications;

public interface SpecificationsRepository extends JpaRepository<Specifications,Integer>{
    List<Specifications> findByProduct(Product product);
    @Query("SELECT s FROM Specifications s WHERE s.color = :color AND s.size_id = :size AND s.product = :product")
    Specifications findByColorAndSizeAndProduct(
        @Param("color") Color color,
        @Param("size") Size size,
        @Param("product") Product product
    );
    // @Query("SELECT s FROM Specifications s WHERE s.product.product_id = :productId AND s.quantity > :quantity")
    // List<Specifications> findByProductIdAndQuantityGreaterThan(@Param("productId") Integer productId, @Param("quantity") int quantity);
}
