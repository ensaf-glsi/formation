package com.ensaf.productms.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = "id")
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private Unit unit;
}
