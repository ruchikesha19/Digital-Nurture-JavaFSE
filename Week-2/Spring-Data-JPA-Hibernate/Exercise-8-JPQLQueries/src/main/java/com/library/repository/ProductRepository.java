package com.library.repository;

import com.library.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query using JPQL
    @Query("SELECT p FROM Product p WHERE p.category = :category AND p.price > :price")
    List<Product> findByCategoryAndMinPrice(@Param("category") String category, @Param("price") double price);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword%")
    List<Product> searchByNameKeyword(@Param("keyword") String keyword);
}
