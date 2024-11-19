package com.esd.prodcrud.controller;

import com.esd.prodcrud.Product;
import com.esd.prodcrud.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    // Create a new product
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    // Get all products
    @GetMapping("getAllProducts")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepo.findById(id).orElse(null);
    }

    // Update a product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productRepo.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            return productRepo.save(product);
        }).orElse(null);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepo.deleteById(id);
        return "Product deleted";
    }

    // Fetch top 2 products in a price range
    @GetMapping("/range")
    public List<Product> getTop2ProductsInPriceRange() {
        return productRepo.findTop2ProductsInPriceRange();
    }
}
