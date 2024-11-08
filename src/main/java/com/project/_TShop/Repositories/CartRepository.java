package com.project._TShop.Repositories;

import com.project._TShop.Entities.Cart;
import com.project._TShop.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {


}
