package com.ensaf.productms.service;

import com.ensaf.data.service.CrudService;
import com.ensaf.productms.entity.Unit;
import com.ensaf.productms.repository.UnitRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

// manager or business
// les accès a la bd et implementation des règles de gestion
@Service
@Slf4j
public class UnitService extends CrudService<Unit, UUID> {
    @Autowired
    @Getter
    private UnitRepository repository;

    public void updateName(UUID id, String name) {
        log.info("patch unit {}, name : {}",  id, name);
        repository.findById(id).ifPresentOrElse(unit -> {
            unit.setName(name);
            repository.save(unit);
        }, () -> {
            throw new RuntimeException(String.format("Unit with id %s not found", id));
        });
    }


}
