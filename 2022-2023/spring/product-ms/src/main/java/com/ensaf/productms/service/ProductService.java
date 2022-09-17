package com.ensaf.productms.service;

import com.ensaf.productms.entity.Product;
import com.ensaf.productms.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import java.util.List;
import java.util.Optional;

// manager or business
// les accès a la bd et implementation des règles de gestion
@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> find() {
        return repository.findAll();
    }

    // return a product with id
    public Product findByName(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Product> findByName(Optional<String> name) {
        log.trace("get products by name {}", name);
//        return repository.findByNameContains(name.map(n -> "%" + n + "%").orElse(""));
        repository.findByName(name.orElse(null));
        repository.findByNameContaining(name.orElse(null));
        repository.findByNameIgnoreCase(name.orElse(null));
        return repository.findByNameContainingIgnoreCase(name.orElse(null));
    }

    public Product create(Product product) {
        log.trace("create new product {}", product);
        return repository.save(product);
    }

    public Product update(Long id, Product product) {
        log.trace("update product {}, new product : {}", id, product);
        if (!repository.existsById(id)) {
            throw new RuntimeException(String.format("Product with id %s not found", id));
        }
        product.setId(id);
        return repository.save(product);
    }

    public void updateName(Long id, String name) {
        log.info("patch product {}, name : {}",  id, name);
        repository.findById(id).ifPresentOrElse(product -> {
            product.setName(name);
            repository.save(product);
        }, () -> {
            throw new RuntimeException(String.format("Product with id %s not found", id));
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
