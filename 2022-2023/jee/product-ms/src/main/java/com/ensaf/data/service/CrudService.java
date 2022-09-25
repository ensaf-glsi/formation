package com.ensaf.data.service;

import com.ensaf.data.entity.IEntityId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Slf4j
public abstract class CrudService<T extends IEntityId<Id>, Id> {

    protected abstract JpaRepository<T, Id> getRepository();

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public T findById(Id id) {
        return getRepository().findById(id).orElseThrow();
    }

    public T create(T entity) {
        log.trace("create new entity {}", entity);
        return getRepository().save(entity);
    }

    public T update(Id id, T entity) {
        log.trace("update entity {}, new entity : {}", id, entity);
        if (!getRepository().existsById(id)) {
            throw new RuntimeException(String.format("Entity with id %s not found", id));
        }
        entity.setId(id);
        return getRepository().save(entity);
    }

    public void delete(Id id) {
        getRepository().deleteById(id);
    }
}
