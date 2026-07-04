package com.library.repository;

import com.library.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query using Native SQL
    @Query(value = "SELECT * FROM products p WHERE p.category = :category", nativeQuery = true)
    List<Product> findByCategoryNative(@Param("category") String category);

    @Query(value = "SELECT * FROM products p WHERE p.price > :price", nativeQuery = true)
    List<Product> findByPriceGreaterThanNative(@Param("price") double price);
}
