package com.nimap.project.repository;

import com.nimap.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("select P form Product p where p.name=: title")
    Product findProductByName(String title);
}
