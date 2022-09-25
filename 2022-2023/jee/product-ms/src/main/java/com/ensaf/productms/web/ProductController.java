package com.ensaf.productms.web;

import com.ensaf.productms.entity.Product;
import com.ensaf.productms.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

//    public ProductController(ProductService service) {
//        this.service = service;
//    }


    // return list of products
    @GetMapping
    public List<Product> find() {
        log.trace("get all products");
        return service.find();
    }

    // return a product with id
    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id) {
        log.trace("get product {}", id);
        return service.findByName(id);
    }

    @GetMapping("by-name")
    public List<Product> findByName(@RequestParam Optional<String> name) {
        log.trace("get products by name {}", name);
        return service.findByName(name);
    }

    // create a new product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        log.trace("create new product {}", product);
        return service.create(product);
    }

    // update product
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        log.trace("update product {}, new product : {}", id, product);
        return service.update(id, product);
    }

    // update partially a product
    @PatchMapping("/{id}")
    public void updateName(@PathVariable Long id, @RequestBody String name) {
        log.info("patch product {}, name : {}",  id, name);
        service.updateName(id, name);
    }

    // delete a product
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        log.trace("delete product {}",  id);
        service.delete(id);
    }

}
