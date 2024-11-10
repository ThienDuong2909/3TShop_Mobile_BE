package com.project._TShop.Repositories;


import com.project._TShop.Entities.Account;
import com.project._TShop.Entities.Size;
import com.project._TShop.Entities.Specifications;
import com.project._TShop.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecificationsRepository extends JpaRepository<Specifications, Integer> {

    @Query(value = "SELECT * FROM Specifications WHERE Specifications.product_id = :product_id", nativeQuery = true)
    Optional<List<Specifications>> findAllByProductId(Integer product_id);

    @Query("SELECT s FROM Specifications s WHERE s.specifications_id = :specifications_id")
    Optional<Specifications> findBySpecificationsId(Integer specifications_id);
    List<Specifications> findByProduct(Product product);

}
