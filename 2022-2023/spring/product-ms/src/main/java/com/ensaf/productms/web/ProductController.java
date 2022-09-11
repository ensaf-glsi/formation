package com.ensaf.productms.web;

import com.ensaf.productms.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {

    // return list of products
    @GetMapping
    public List<Product> find() {
        log.trace("get all products");
        return Collections.emptyList();
    }

    // return a product with id
    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id) {
        log.trace("get product {}", id);
        return new Product();
    }

    @GetMapping("by-name")
    public List<Product> findOne(@RequestParam Optional<String> name) {
        log.trace("get products by name {}", name);
        return Collections.emptyList();
    }

    // create a new product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        log.trace("create new product {}", product);
        return new Product();
    }

    // update product
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        log.trace("update product {}, new product : {}", id, product);
        return new Product();
    }

    // update partially a product
    @PatchMapping("/{id}")
    public void patch(@PathVariable Long id, @RequestBody String name) {
        log.info("patch product {}, name : {}",  id, name);
    }

    // delete a product
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        log.trace("delete product {}",  id);
    }

}
