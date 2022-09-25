package com.ensaf.productms.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")

@SuperBuilder
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 120)
    private String name;
    @Column(name = "unit_price")
    private BigDecimal price;
//    private Unit unit;
}
