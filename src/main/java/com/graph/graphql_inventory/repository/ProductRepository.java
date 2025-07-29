package com.graph.graphql_inventory.repository;

import com.graph.graphql_inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
