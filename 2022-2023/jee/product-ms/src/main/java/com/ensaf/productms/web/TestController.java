package com.ensaf.productms.web;

import com.ensaf.productms.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ProductRepository productRepository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/say-hello")
    public String sayHello(@RequestParam String name) {
        return String.format("Hello %s!", name);
    }


    @GetMapping("/test")
    public Object test() {
        return productRepository.countTotalByName();
    }



}
