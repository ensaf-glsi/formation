package com.ensaf.productms.entity;

import com.ensaf.data.entity.IEntityId;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "products")

@SuperBuilder
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
// @MappedSuperclass
public class Product implements IEntityId<Long> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 120)
    private String name;
    @Column(name = "unit_price")
    private BigDecimal price;
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductType type = ProductType.STOCKABLE;

    @Temporal(TemporalType.DATE)
    private Date createdDate = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    private Unit unit;

    @Transient
    private String transientField;
}
