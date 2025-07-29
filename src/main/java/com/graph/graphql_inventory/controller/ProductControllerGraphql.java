package com.graph.graphql_inventory.controller;

import com.graph.graphql_inventory.entity.Product;
import com.graph.graphql_inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ProductControllerGraphql {

    @Autowired
    private ProductService productService;

    public ProductControllerGraphql(ProductService productService){
        this.productService=productService;
    }

    @QueryMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category){
        return productService.getProductsByCategory(category);
    }

    @MutationMapping
    public Product updateStock(@Argument int id,@Argument int stock){
        return productService.updateStock(id,stock);
    }



}
