package com.dharmendra.weekly_test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Integer> {
//    @Query(value = "select product_id from product where date =:date",nativeQuery = true)
//    List<Product> findProductsOfParticular(LocalDate date);

    List<Product> findProductByDate(LocalDate date);
    @Query(value = "select * from product where fk_user_id =:userId",nativeQuery = true)
    List<Product> findProductByFkUserId(Integer userId);
}
