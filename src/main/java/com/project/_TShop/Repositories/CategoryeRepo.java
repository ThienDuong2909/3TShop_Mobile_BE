package com.project._TShop.Repositories;

import com.project._TShop.Entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project._TShop.Entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryeRepo extends JpaRepository<Category, Integer>{
    @Query("SELECT c FROM Category c WHERE c.category_id = :category_id")
    Category findByCategoryId(@Param("category_id") Integer category_id);


    Category findByName(String name);

//    Optional<Category> findByCategoryId(Integer categoryId);
}
