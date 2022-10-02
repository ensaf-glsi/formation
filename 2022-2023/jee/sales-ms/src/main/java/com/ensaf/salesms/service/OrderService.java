package com.ensaf.salesms.service;

import com.ensaf.data.service.CrudService;
import com.ensaf.salesms.entity.Order;
import com.ensaf.salesms.repository.OrderRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService extends CrudService<Order, UUID> {
    @Getter
    private final OrderRepository repository;

}
