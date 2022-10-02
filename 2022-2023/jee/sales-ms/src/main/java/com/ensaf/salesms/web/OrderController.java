package com.ensaf.salesms.web;

import com.ensaf.salesms.entity.Order;
import com.ensaf.salesms.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping
    public List<Order> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable UUID id, @RequestBody Order order) {
        return service.update(id, order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

}
