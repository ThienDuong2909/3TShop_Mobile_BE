package com.project._TShop.Repositories;

import com.project._TShop.Entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    Color findByColor_id(int colo_id);

}
