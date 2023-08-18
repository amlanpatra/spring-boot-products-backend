package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class TestController {

    @Autowired
    ProductService service;


    @GetMapping("/test")
    public String test() {
        return "Working!!!\nThis is test method";
    }


    @PostMapping("/create")
    public Product savePRoduct(@RequestBody Product p) {
        System.out.println("in create " + p);
        return service.saveProduct(p);
    }

    @GetMapping("/read/{id}")
    public Product readProduct(@PathVariable("id") int productId) {
        System.out.println("in product id");
        return service.getProductById(productId);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product p) {
        System.out.println("in update");
        return service.updateProduct(p);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int productId) {
        System.out.println("in delete");
        return service.deleteProduct(productId);
    }


    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }
}
