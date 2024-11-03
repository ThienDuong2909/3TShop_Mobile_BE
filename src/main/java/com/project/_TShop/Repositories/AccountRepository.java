package com.project._TShop.Repositories;

import com.project._TShop.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface  AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);

}
