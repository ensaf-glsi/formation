package com.ensaf.productms.entity;

import com.ensaf.data.entity.IEntityId;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Unit implements IEntityId<UUID> {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
}
