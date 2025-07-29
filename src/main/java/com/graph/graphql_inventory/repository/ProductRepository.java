package com.graph.graphql_inventory.repository;

import com.graph.graphql_inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findByCategory(String category);
}
