package com.ensaf.salesms.entity;

import com.ensaf.data.entity.IEntityId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Order implements IEntityId<UUID> {
    @Id
    @GeneratedValue
    private UUID id;
    private Long customerId;
    @Builder.Default
    @Temporal(TemporalType.DATE)
    private Date createdDate = new Date();
    @Builder.Default
    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    @OneToMany(
//        mappedBy = "order",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "order_id")
    @JsonIgnore
    @Singular
    @ToString.Exclude
    private List<OrderLine> lines;

}
