package com.ensaf.productms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Unit {
    private Long id;
    private String name;
}
