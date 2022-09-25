package com.ensaf.productms.web;

import com.ensaf.productms.entity.Unit;
import com.ensaf.productms.service.UnitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/units")
@Slf4j
@RequiredArgsConstructor
public class UnitController {

    private final UnitService service;

    @GetMapping
    public List<Unit> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Unit findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Unit create(@RequestBody Unit unit) {
        return service.create(unit);
    }

    @PutMapping("/{id}")
    public Unit update(@PathVariable UUID id, @RequestBody Unit unit) {
        return service.update(id, unit);
    }

    @PatchMapping("/{id}")
    public void updateName(@PathVariable UUID id, @RequestBody String name) {
        service.updateName(id, name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

}
