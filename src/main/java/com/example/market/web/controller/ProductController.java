package com.example.market.web.controller;

import com.example.market.domain.Product;
import com.example.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value ="/all")
    public List<Product> getAll() {
        return productService.getAll();

    }
    @GetMapping(value ="/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId) {

        return productService.getProduct(productId);
    }
    @GetMapping(value ="/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable int categoryId) {
        return productService.getByCategory(categoryId);

    }
    @PostMapping(value = "/save")
    public Product save(@RequestBody Product product) {

        return productService.save(product);
    }
@DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable("id") int productId) {

        return productService.delete(productId);
    }

}
