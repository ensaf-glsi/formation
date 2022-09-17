package com.ensaf.productms.repository;

import com.ensaf.productms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // JPQL
    @Query("select p from Product p where upper(p.name) like upper(:name)")
    List<Product> findByNameContains(String name);


    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByName(String name);
    List<Product> findByNameIgnoreCase(String name);

}