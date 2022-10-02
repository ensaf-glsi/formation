package com.ensaf.salesms.entity;

import com.ensaf.data.entity.IEntityId;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_lines")

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class OrderLine implements IEntityId<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private Long quantity;
    private Long productId;
    private String designation;
    private BigDecimal price;

    @ManyToOne
    private Order order;

}
