package com.graph.graphql_inventory.controller;

import com.graph.graphql_inventory.entity.Product;
import com.graph.graphql_inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductControllerGraphql {

    @Autowired
    private ProductService productService;

    public ProductControllerGraphql(ProductService productService){
        this.productService=productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category){
        return productService.getProductsByCategory(category);
    }



}
