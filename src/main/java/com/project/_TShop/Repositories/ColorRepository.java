package com.project._TShop.Repositories;

import com.project._TShop.Entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ColorRepository extends JpaRepository<Color, Integer> {
    @Query("SELECT c FROM Color c WHERE c.color_id = :color_id")
    Color findByColorId(@Param("color_id") int color_id);
    boolean existsByHex(String hex);
}
