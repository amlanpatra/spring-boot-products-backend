package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public Product saveProduct(Product product) {
        Product current = repo.findById(product.getId()).orElse(null);
        if (current != null) return null;
        return repo.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repo.saveAll(products);
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repo.findByName(name);
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public String deleteProduct(int id) {
        repo.deleteById(id);
        return "Product deleted with id " + id;
    }

    public Product updateProduct(Product product) {
        Product current = repo.findById(product.getId()).orElse(null);

        if (current == null)
            return null;

        current.setName(product.getName());
        current.setPrice(product.getPrice());
        current.setQuantity(product.getQuantity());
        return repo.save(current);
    }
}
