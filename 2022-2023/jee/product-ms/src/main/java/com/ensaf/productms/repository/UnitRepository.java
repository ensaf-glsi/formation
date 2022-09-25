package com.ensaf.productms.repository;

import com.ensaf.productms.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UnitRepository extends JpaRepository<Unit, UUID> {
}