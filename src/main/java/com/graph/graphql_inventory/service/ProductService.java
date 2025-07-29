package com.graph.graphql_inventory.service;

import com.graph.graphql_inventory.entity.Product;
import com.graph.graphql_inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }

    //for sales team
    public Product updateStock(int id,int quantity){
        Product exisitngProduct = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found with given ID : "+id));
        exisitngProduct.setStock(quantity);
        return productRepository.save(exisitngProduct);
    }

    //for warehouse shipment
    public Product recieveNewShipment(int id,int quantity){
        Product exisitngProduct = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found with given ID : "+id));

        exisitngProduct.setStock(exisitngProduct.getStock()+quantity);
        return productRepository.save(exisitngProduct);
    }

}
